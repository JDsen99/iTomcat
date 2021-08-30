package com.ss.itomcat.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:20
 */
public class WebappClassLoader extends URLClassLoader {

    private static final String CLASS_FILE_SUFFIX = ".class";

    private Map<String,Class<?>> classMap = new ConcurrentHashMap<>();

    private ClassLoader javaClassLoader;

    private ClassLoader parent;

    /**
     * 初始化webappClassLoader
     * @param urls
     */
    public WebappClassLoader(URL[] urls) {
        super(urls);
        ClassLoader parent = getParent();

        if (parent == null) {
            parent = getSystemClassLoader();
        }
        this.parent = parent;

        ClassLoader javaClassLoader = String.class.getClassLoader();

        if (javaClassLoader == null) {
            javaClassLoader = getSystemClassLoader();
            while (javaClassLoader.getParent() != null) {
                javaClassLoader = javaClassLoader.getParent();
            }
        }
        this.javaClassLoader = javaClassLoader;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> clazz = null;
            clazz = findLoadedClass0(name);
            if (clazz != null) {
                if (resolve) {
                    resolveClass(clazz);
                }
                return clazz;
            }
            //调用父类查看是否已经加载该类
            clazz = findLoadedClass(name);
            if (clazz != null) {
                if (resolve) {
                    resolveClass(clazz);
                }
                return clazz;
            }
            String resourceName = binaryNameToPath(name,false);
            ClassLoader javaClassLoader = getJavaClassLoader();
            boolean tryLoadingFromJavaClassLoader;
            try {
                URL url = javaClassLoader.getResource(resourceName);
                tryLoadingFromJavaClassLoader = (url != null);
            } catch (Throwable t) {
                tryLoadingFromJavaClassLoader = true;
            }

            if (tryLoadingFromJavaClassLoader) {
                try {
                    clazz = javaClassLoader.loadClass(name);
                    if (clazz != null) {
                        if (resolve) {
                            resolveClass(clazz);
                        }
                        return clazz;
                    }
                } catch (ClassNotFoundException e) {
                    //ignore
                }
            }
            try {
                clazz = Class.forName(name, false, parent);
                if (clazz != null){
                    return clazz;
                }
            }catch (Exception e){
                //ignore
            }
            clazz = findClass(name);
            if (clazz != null){
                String key = binaryNameToPath(name, true);
                classMap.put(key ,clazz);
                return clazz;
            }
        }
        throw new ClassNotFoundException(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = binaryNameToPath(name,true);
        URL[] urls = super.getURLs();
        File classPath = null;
        for (URL url : urls) {
            File base = null;
            try {
                base = new File(url.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            classPath = new File(base,path);
            if (classPath.exists()) {
                break;
            }
            classPath = null;
        }
        if (classPath == null) {
            throw new ClassNotFoundException();
        }
        byte[] classByte = loadClassByte(classPath);
        if (classByte == null) {
            throw new ClassNotFoundException();
        }
        return this.defineClass(name,classByte,0,classByte.length);
    }

    private byte[] loadClassByte(File classFile) {
        ByteArrayOutputStream bos = null;
        FileInputStream fis = null;

        try {
            bos = new ByteArrayOutputStream();
            fis = new FileInputStream(classFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
            bos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private ClassLoader getJavaClassLoader() {
        return this.javaClassLoader;
    }

    protected  Class<?> findLoadedClass0(String name) {
        String path = binaryNameToPath(name,true);
        return classMap.get(path);
    }

    /**
     * 将name转换成path
     * @param binaryName
     * @param withLeadingSlash
     * @return
     */
    private String binaryNameToPath(String binaryName, boolean withLeadingSlash) {
        StringBuilder path = new StringBuilder(7 + binaryName.length());
        if (withLeadingSlash) {
            path.append('/');
        }
        path.append(binaryName.replace('.','/'));
        path.append(CLASS_FILE_SUFFIX);
        return path.toString();
    }
}

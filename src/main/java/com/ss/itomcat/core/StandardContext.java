package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Context;
import com.ss.itomcat.catalina.Wrapper;
import com.ss.itomcat.servlet.Servlet;
import com.ss.itomcat.util.LifecycleBase;
import com.ss.itomcat.util.LogUtil;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:17
 */
public class StandardContext extends LifecycleBase implements Context {

    private static final Logger logger = LogUtil.getLogger();

    private Map<String,Wrapper> wrapperMap = new ConcurrentHashMap<>();

    private String contextName;

    private ClassLoader classLoader;

    @Override
    protected void initInternal() {
        Set<Map.Entry<String, Wrapper>> entries = wrapperMap.entrySet();
        for (Map.Entry<String, Wrapper> entry : entries) {
            Wrapper wrapper = entry.getValue();
            try {
                Class<?> servletClass = this.classLoader.loadClass(wrapper.getClassName());
                Servlet servlet = (Servlet) servletClass.getDeclaredConstructor().newInstance();
                wrapper.setServlet(servlet);
                servlet.init();
                logger.info("{} servlet init",servlet.getClass().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void startInternal() {

    }

    @Override
    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    @Override
    public String getContextName() {
        return this.contextName;
    }

    @Override
    public void addWrapper(Wrapper wrapper) {
        wrapperMap.put(wrapper.getUrlPattern(),wrapper);
    }

    @Override
    public Wrapper findWrapper(String servletName) {
        return wrapperMap.get(servletName);
    }

    @Override
    public void setClassloader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }
}

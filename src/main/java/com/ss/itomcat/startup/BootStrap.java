package com.ss.itomcat.startup;

import com.ss.itomcat.util.LogUtil;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-15:40
 */
public class BootStrap {

    /**
     * 日志对象
     */
    private static final Logger log = LogUtil.getLogger(BootStrap.class);

    /**
     * Bootstrap 守护进程对象
     */
    private static volatile BootStrap daemon = null;

    /**
     * Catalina 守护进程对象
     */
    private Object catalinaDaemon = null;


    public static void main(String[] args) {
        BootStrap bootStrap = new BootStrap();

        // bootstrap初始化
        try {
            bootStrap.init();
        } catch (Exception e) {
            log.error("init error");
        }

        daemon = bootStrap;

        try {
            daemon.load();
        } catch (Exception e) {
            log.error("load error",e);
        }

        try {
            //daemon.start();
        } catch (Exception e) {
            log.error("start error");
        }
    }

    private void init() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> startUpClass = this.getClass().getClassLoader().loadClass("com.ss.itomcat.startup.Catalina");
        Object instance = startUpClass.getConstructor().newInstance();
        catalinaDaemon = instance;
    }

    /**
     * 反射调用Catalina.load() 初始化
     * @throws Exception
     */
    private void load() throws Exception {
        Long l1 = System.currentTimeMillis();
        String methodName = "load";
        Method method = catalinaDaemon.getClass().getMethod(methodName,(Class [])null);
        method.invoke(catalinaDaemon,(Class [])null);
        Long l2 = System.currentTimeMillis();
        log.info("{} loading completed takes {} ms",this.getClass().getSimpleName(),(l2 - l1));
    }

    private void start() throws Exception {
        Long l1 = System.currentTimeMillis();
        String methodName = "start";
        Method method = catalinaDaemon.getClass().getMethod(methodName,(Class [])null);
        method.invoke(catalinaDaemon,null);
        Long l2 = System.currentTimeMillis();
        log.info("{} start completed takes {} ms",this.getClass().getSimpleName(),(l2 - l1));
    }
}

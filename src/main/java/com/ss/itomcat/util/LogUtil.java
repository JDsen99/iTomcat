package com.ss.itomcat.util;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-15:56
 */
public class LogUtil {

    public static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }
    public static Logger getLogger() {
        return LoggerFactory.getLogger("app");
    }
}

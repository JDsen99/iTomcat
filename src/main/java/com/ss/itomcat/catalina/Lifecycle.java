package com.ss.itomcat.catalina;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-16:58
 */
public interface Lifecycle {
    /**
     * 初始化容器
     */
    void init();

    /**
     * 启动容器
     */
    void start();

    /**
     * 停止容器
     */
    void stop();

    /**
     * 销毁容器
     */
    void destroy();
}

package com.ss.itomcat.catalina;

import com.ss.itomcat.net.Connector;

import java.util.concurrent.Executor;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:19
 */
public interface Server extends Lifecycle{
    /**
     * 设置一组Services
     * @param services
     */
    void setServices(Service[] services);

    /**
     * 获取一组定义的Services
     * @return
     */
    Service[] findServices();

    /**
     * 添加连接器 Connector
     */
    void addConnector(Connector connector);

    /**
     * 获取执行器
     * @return Executor
     */
    Executor getExecutor();
}

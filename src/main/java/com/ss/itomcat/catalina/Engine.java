package com.ss.itomcat.catalina;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:20
 */
public interface Engine extends Container{

    /**
     * 获取服务
     * @return
     */
    Service getService();

    /**
     * 设置服务
     * @param service
     */
    void setService(Service service);

    /**
     * 设置一组Host
     * @param hosts
     */
    void setHost(Host[] hosts);

    /**
     * 获取一组host
     * @return
     */
    Host[] getHosts();
}

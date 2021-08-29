package com.ss.itomcat.catalina;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:19
 */
public interface Service extends Lifecycle{

    /**
     * 设置关联的server
     * @param server
     */
    void setServer(Server server);

    /**
     * 获取引擎列表
     * @return
     */
    Engine[] getEngine();

    /**
     * 添加引擎
     * @param engine
     */
    void addEngine(Engine engine);

}

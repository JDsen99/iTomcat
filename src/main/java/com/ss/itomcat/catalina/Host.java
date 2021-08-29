package com.ss.itomcat.catalina;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:20
 */
public interface Host extends Container{

    /**
     * 蛇者关联的engine
     * @param engine
     */
    void setEngine(Engine engine);

    /**
     * 获取engine
     * @return
     */
    Engine getEngine();

    /**
     * 获取主机名
     * @return
     */
    String getName();

    /**
     * 设置应用程序根目录
     * @param appBase
     */
    void setAppBase(String appBase);

    /**
     * 获取应用程序根目录
     * @return
     */
    String getAppBase();

    /**
     * 添加上下文
     * @param context
     */
    void addContext(Context context);

    /**
     * 获取上下文
     * @return
     */
    Context[] getContexts();
}

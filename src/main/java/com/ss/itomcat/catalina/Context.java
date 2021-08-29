package com.ss.itomcat.catalina;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:20
 */
public interface Context extends Container{
    /**
     * 设置应用上下文名称
     * @param contextName
     */
    void setContextName(String contextName);


    /**
     * 获取应用上下文名称
     * @return
     */
    String getContextName();

    /**
     * 添加servlet容器
     * @param wrapper
     */
    void addWrapper(Wrapper wrapper);

    /**
     * 查找Servlet
     * @return
     */
    Wrapper findWrapper();

    /**
     * 设置web的ClassLoader
     * @param classLoader
     */
    void setClassloader(ClassLoader classLoader);
}

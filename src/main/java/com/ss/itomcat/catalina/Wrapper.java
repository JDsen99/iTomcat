package com.ss.itomcat.catalina;

import com.ss.itomcat.servlet.Servlet;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:21
 */
public interface Wrapper extends Container{
    /**
     * 获取servlet
     * @return
     */
    Servlet getServlet();

    /**
     * 设置servlet
     * @param servlet
     */
    void setServlet(Servlet servlet);

    /**
     * 设置URL Pattern
     * @param urlPattern
     */
    void setUrlPattern(String urlPattern);

    /**
     * 获取urlPattern
     * @return
     */
    String getUrlPattern();

    /**
     * 设置className
     * @param className
     */
    void setClassName(String className);

    /**
     * 获取className
     * @return
     */
    String getClassName();

    /**
     * 设置ServletName
     * @param servletName
     */
    void setServletName(String servletName);

    /**
     * 获取ServletName
     * @return
     */
    String getServletName();

    /**
     * 设置上下文
     * @param context
     */
    void setContext(Context context);
}

package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Context;
import com.ss.itomcat.catalina.Wrapper;
import com.ss.itomcat.servlet.Servlet;
import com.ss.itomcat.util.LifecycleBase;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:33
 */
public class StandardWrapper implements Wrapper {
    /**
     * 类名
     */
    private String className;
    /**
     * servlet名
     */
    private String servletName;
    /**
     * url匹配路径
     */
    private String urlPattern;

    /**
     * servlet
     */
    private Servlet servlet;

    /**
     * 上下文
     */
    private Context context;




    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
    @Override
    public Servlet getServlet() {
        return null;
    }

    @Override
    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    @Override
    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    @Override
    public String getUrlPattern() {
        return this.urlPattern;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getClassName() {
        return this.className;
    }

    @Override
    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    @Override
    public String getServletName() {
        return this.servletName;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}

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
public class StandardWrapper extends LifecycleBase implements Wrapper {




    @Override
    protected void initInternal() {

    }

    @Override
    protected void startInternal() {

    }

    @Override
    public Servlet getServlet() {
        return null;
    }

    @Override
    public void setServlet(Servlet servlet) {

    }

    @Override
    public void setUrlPattern(String urlPattern) {

    }

    @Override
    public String getUrlPattern() {
        return null;
    }

    @Override
    public void setClassName(String className) {

    }

    @Override
    public String getClassName() {
        return null;
    }

    @Override
    public void setServletName(String servletName) {

    }

    @Override
    public String getServletName() {
        return null;
    }

    @Override
    public void setContext(Context context) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

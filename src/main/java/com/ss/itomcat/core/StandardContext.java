package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Context;
import com.ss.itomcat.catalina.Wrapper;
import com.ss.itomcat.util.LifecycleBase;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:17
 */
public class StandardContext extends LifecycleBase implements Context {


    @Override
    protected void initInternal() {

    }

    @Override
    protected void startInternal() {

    }

    @Override
    public void setContextName(String contextName) {

    }

    @Override
    public String getContextName() {
        return null;
    }

    @Override
    public void addWrapper(Wrapper wrapper) {

    }

    @Override
    public Wrapper findWrapper() {
        return null;
    }

    @Override
    public void setClassloader(ClassLoader classLoader) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

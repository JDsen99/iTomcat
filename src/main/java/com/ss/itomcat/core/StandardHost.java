package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Context;
import com.ss.itomcat.catalina.Engine;
import com.ss.itomcat.catalina.Host;
import com.ss.itomcat.util.LifecycleBase;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:11
 */
public class StandardHost extends LifecycleBase implements Host {

    @Override
    protected void initInternal() {

    }

    @Override
    protected void startInternal() {

    }
    @Override
    public void setEngine(Engine engine) {

    }

    @Override
    public Engine getEngine() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setAppBase(String appBase) {

    }

    @Override
    public String getAppBase() {
        return null;
    }

    @Override
    public void addContext(Context context) {

    }

    @Override
    public Context[] getContexts() {
        return new Context[0];
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Context;
import com.ss.itomcat.catalina.Engine;
import com.ss.itomcat.catalina.Host;
import com.ss.itomcat.util.LifecycleBase;

import java.util.Arrays;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:11
 */
public class StandardHost extends LifecycleBase implements Host {

    private Engine engine;
    private String name;
    private String appBase;
    private Context[] contexts = new Context[0];

    @Override
    protected void initInternal() {
        for (int i = 0; i < contexts.length; i++) {
            contexts[i].init();
        }
    }

    @Override
    protected void startInternal() {

    }
    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return  this.name;
    }

    @Override
    public void setAppBase(String appBase) {
        this.appBase = appBase;
    }

    @Override
    public String getAppBase() {
        return this.appBase;
    }

    @Override
    public void addContext(Context context) {
        Context[] result = new Context[contexts.length+1];
        System.arraycopy(this.contexts,0,result,0,this.contexts.length);
        result[contexts.length] = context;
        this.contexts = result;
    }

    @Override
    public Context[] getContexts() {
        return this.contexts;
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

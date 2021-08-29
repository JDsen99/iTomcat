package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Server;
import com.ss.itomcat.catalina.Service;
import com.ss.itomcat.net.Connector;
import com.ss.itomcat.util.LifecycleBase;

import java.util.concurrent.Executor;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-14:59
 */
public class StandardServer extends LifecycleBase implements Server {

    private Service[] services = new Service[0];
    private Connector[] connectors = new Connector[0];
    private Executor executor;
    @Override
    protected void initInternal() {

    }

    @Override
    protected void startInternal() {

    }


    @Override
    public void setServices(Service[] services) {
        this.services = services;
    }

    @Override
    public Service[] findServices() {
        return this.services;
    }

    @Override
    public void addConnector(Connector connector) {
        Connector[] result = new Connector[connectors.length+1];
        System.arraycopy(connectors,0,result,0,connectors.length);
        result[connectors.length] = connector;
        connectors = result;
    }

    @Override
    public Executor getExecutor() {
        return this.executor;
    }
    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

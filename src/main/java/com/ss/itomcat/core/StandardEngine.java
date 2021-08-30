package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Engine;
import com.ss.itomcat.catalina.Host;
import com.ss.itomcat.catalina.Service;
import com.ss.itomcat.util.LifecycleBase;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:10
 */
public class StandardEngine extends LifecycleBase implements Engine {

    private Service service;
    private Host[] hosts = new Host[0];


    @Override
    protected void initInternal() {
        for (int i = 0; i < hosts.length; i++) {
            hosts[i].init();
        }
    }

    @Override
    protected void startInternal() {

    }

    @Override
    public Service getService() {
        return this.service;
    }

    @Override
    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void setHost(Host[] hosts) {
        this.hosts = hosts;
    }

    @Override
    public Host[] getHosts() {
        return this.hosts;
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

}

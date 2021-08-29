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




    @Override
    protected void initInternal() {

    }

    @Override
    protected void startInternal() {

    }

    @Override
    public Service getService() {
        return null;
    }

    @Override
    public void setService(Service service) {

    }

    @Override
    public void setHost(Host[] hosts) {

    }

    @Override
    public Host[] getHosts() {
        return new Host[0];
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

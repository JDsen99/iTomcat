package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Engine;
import com.ss.itomcat.catalina.Server;
import com.ss.itomcat.catalina.Service;
import com.ss.itomcat.util.LifecycleBase;

import javax.naming.NamingEnumeration;
import java.util.Arrays;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:32
 */
public class StandardService extends LifecycleBase implements Service {

    private Server server;

    private Engine[] engines = new Engine[0];


    @Override
    protected void initInternal() {
        for (Engine engine : engines) {
            engine.init();
        }
    }

    @Override
    protected void startInternal() {

    }


    @Override
    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public Engine[] getEngines() {
        return this.engines;
    }

    @Override
    public void addEngine(Engine engine) {
        Engine[] result = new Engine[engines.length+1];
        System.arraycopy(engines,0,result,0,engines.length);
        result[engines.length] = engine;
        engines = result;
    }
    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public String toString() {
        return "StandardService{" +
                "server=" +
                ", engines=" + Arrays.toString(engines) +
                '}';
    }
}

package com.ss.itomcat.core;

import com.ss.itomcat.catalina.Server;
import com.ss.itomcat.catalina.Service;
import com.ss.itomcat.net.Connector;
import com.ss.itomcat.util.LifecycleBase;

import java.util.Arrays;
import java.util.concurrent.*;

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
        
        for (Service service : services){
            service.init();
        }
        for (Connector connector : connectors) {
            connector.init();
        }

        // TODO: 硬编码定义线程池
        int corePoolSize = 10;
        int maximumPoolSize = 30;
        long keepAliveTime = 60L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(30);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        this.executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
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
        this.connectors = result;

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

    @Override
    public String toString() {
        return "StandardServer{" +
                "services=" + Arrays.toString(services) +
                ", connectors=" + Arrays.toString(connectors) +
                ", executor=" + executor +
                '}';
    }
}

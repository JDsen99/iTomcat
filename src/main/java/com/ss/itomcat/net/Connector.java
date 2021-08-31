package com.ss.itomcat.net;

import com.ss.itomcat.catalina.Server;
import com.ss.itomcat.catalina.Service;
import com.ss.itomcat.coyote.ProtocolHandler;
import com.ss.itomcat.util.LifecycleBase;

import java.io.IOException;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:38
 */
public class Connector extends LifecycleBase {
    /**
     * 端口
     */
    private int port;

    /**
     * service
     */
    private Service service;

    /**
     * server
     */
    private Server server;

    /**
     * protocolHandler 协议处理器
     */
    private ProtocolHandler protocolHandler;

    public Connector(ProtocolHandler protocolHandler) {
        this.protocolHandler = protocolHandler;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    protected void initInternal() {
        try {
            protocolHandler.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void startInternal() {

        try {
            protocolHandler.setExecutor(server.getExecutor());
            protocolHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}

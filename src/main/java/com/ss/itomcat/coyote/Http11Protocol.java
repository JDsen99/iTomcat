package com.ss.itomcat.coyote;

import com.ss.itomcat.net.AbstractEndpoint;
import com.ss.itomcat.net.Connector;
import com.ss.itomcat.util.LogUtil;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:49
 */
public class Http11Protocol implements ProtocolHandler{

    private static final Logger logger = LogUtil.getLogger();

    /**
     * 执行器
     */
    private Executor executor;

    /**
     * 连接器
     */
    private Connector connector;
    /**
     * 端点
     */
    private AbstractEndpoint endpoint;

    @Override
    public void init() throws IOException {
        endpoint.init();
        logger.info("{} init",this.getClass().getName());
    }

    @Override
    public void start() throws IOException {

    }

    public Http11Protocol(AbstractEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Connector getConnector() {
        return this.connector;
    }

    @Override
    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    @Override
    public Executor getExecutor() {
        return this.executor;
    }

    @Override
    public int getPort() {
        return this.connector.getPort();
    }




}

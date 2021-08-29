package com.ss.itomcat.coyote;

import com.ss.itomcat.net.AbstractEndpoint;
import com.ss.itomcat.net.Connector;

import java.util.concurrent.Executor;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:49
 */
public class Http11Protocol implements ProtocolHandler{

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
    public void init() {

    }

    public Http11Protocol(AbstractEndpoint endpoint) {
        this.endpoint = endpoint;
    }


}

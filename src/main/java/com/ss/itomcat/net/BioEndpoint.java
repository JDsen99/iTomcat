package com.ss.itomcat.net;

import com.ss.itomcat.coyote.Adapter;
import com.ss.itomcat.coyote.ProtocolHandler;
import com.ss.itomcat.util.LogUtil;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:42
 */
public class BioEndpoint extends AbstractEndpoint {

    private static final Logger logger = LogUtil.getLogger(BioEndpoint.class);

    private ProtocolHandler protocolHandler;

    private Adapter adapter;

    private ServerSocket serverSocket;

    public BioEndpoint(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void setProtocolHandler(ProtocolHandler protocolHandler) {
        this.protocolHandler = protocolHandler;
    }

    @Override
    public void init() throws IOException {
        bind();
    }

    @Override
    public void start() throws IOException {

    }

    @Override
    public void bind() throws IOException {
        serverSocket = new ServerSocket(protocolHandler.getPort());
        logger.info("{} 监听端口：[{}]",this.getClass().getName(),protocolHandler.getPort());
    }
}

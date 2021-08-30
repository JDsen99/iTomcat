package com.ss.itomcat.net;

import com.ss.itomcat.coyote.Adapter;
import com.ss.itomcat.coyote.ProtocolHandler;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:42
 */
public class BioEndpoint extends AbstractEndpoint {

    private ProtocolHandler protocolHandler;

    private Adapter adapter;

    private ServerSocket serverSocket;

    public BioEndpoint(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void setProtocolHandler(ProtocolHandler protocolHandler) {

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
    }
}

package com.ss.itomcat.net;

import com.ss.itomcat.coyote.ProtocolHandler;

import java.io.IOException;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:42
 */
public abstract class AbstractEndpoint {
    /**
     * 设置协议处理器
     * @param protocolHandler 协议处理器
     */
    public abstract void setProtocolHandler(ProtocolHandler protocolHandler);

    /**
     * 初始化
     * @throws IOException
     */
    public abstract void init() throws IOException;

    /**
     * 启动
     * @throws IOException
     */
    public abstract void start() throws IOException;

    /**
     * 绑定
     * @throws IOException
     */
    public abstract void bind() throws IOException;
}

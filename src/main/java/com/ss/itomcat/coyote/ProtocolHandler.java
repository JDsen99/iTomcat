package com.ss.itomcat.coyote;

import com.ss.itomcat.net.Connector;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:48
 */
public interface ProtocolHandler {
    /**
     * 设置执行器
     * @param executor
     */
    void setExecutor(Executor executor);

    /**
     * 获取连接器
     * @return
     */
    Connector getConnector();

    /**
     * 设置执行器
     * @param connector
     */
    void setConnector(Connector connector);

    /**
     * 获取执行器
     * @return
     */
    Executor getExecutor();

    /**
     * 获取端口
     * @return
     */
    int getPort();

    /**
     * 初始化
     * @throws IOException
     */
    void init() throws IOException;

    /**
     * 启动
     * @throws IOException
     */
    void start() throws IOException;
}

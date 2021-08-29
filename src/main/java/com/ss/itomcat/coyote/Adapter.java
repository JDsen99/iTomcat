package com.ss.itomcat.coyote;

import com.ss.itomcat.net.Connector;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:31
 */
public interface Adapter {
    /**
     * 获取连接器
     * @return
     */
    Connector getConnector();

    /**
     * 设置连接器
     * @param connector 连接器
     */
    void setConnector(Connector connector);

    /**
     * service服务
     * @param request 请求
     * @param response 响应
     */
    void service(Request request , Response response);
}

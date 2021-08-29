package com.ss.itomcat.servlet;

import com.ss.itomcat.coyote.Request;
import com.ss.itomcat.coyote.Response;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-9:41
 */
public interface Servlet {
    /**
     * 初始化
     */
    void init();

    /**
     * 销毁
     */
    void destroy();

    /**
     *  服务
     * @param request
     * @param response
     */
    void service(Request request, Response response);

}

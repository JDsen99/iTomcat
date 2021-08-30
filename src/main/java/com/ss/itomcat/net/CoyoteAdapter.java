package com.ss.itomcat.net;

import com.ss.itomcat.coyote.Adapter;
import com.ss.itomcat.coyote.Request;
import com.ss.itomcat.coyote.Response;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:31
 */
public class CoyoteAdapter implements Adapter {
    @Override
    public Connector getConnector() {
        return null;
    }

    @Override
    public void setConnector(Connector connector) {

    }

    @Override
    public void service(Request request, Response response) {

    }
}

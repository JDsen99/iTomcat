package com.ss.itomcat.net;

import com.ss.itomcat.coyote.Adapter;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-15:42
 */
public class BioEndpoint extends AbstractEndpoint {
    private Adapter adapter;

    public BioEndpoint(Adapter adapter) {
        this.adapter = adapter;
    }
}

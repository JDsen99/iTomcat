package com.ss.itomcat.loader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/29-16:20
 */
public class WebappClassLoader extends URLClassLoader {

    public WebappClassLoader(URL[] urls) {
        super(urls);
    }
}

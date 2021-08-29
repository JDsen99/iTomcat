package com.ss.itomcat.util;

import com.ss.itomcat.catalina.Lifecycle;
import org.slf4j.Logger;
import sun.rmi.runtime.Log;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-17:25
 */
public abstract class LifecycleBase implements Lifecycle {

    private static final Logger logger = LogUtil.getLogger(LifecycleBase.class);

    @Override
    public void init() {
        logger.info("{} 初始化中...",this.getClass().getName());
        initInternal();
        logger.info("{} 初始化完成.",this.getClass().getName());
    }

    @Override
    public void start() {
        logger.info("{} 启动中...",this.getClass().getName());
        startInternal();
        logger.info("{} 启动完成.",this.getClass().getName());
    }

    /**
     * 内部初始化
     */
    protected abstract void initInternal();

    /**
     * 内部启动
     */
    protected abstract void startInternal();


}

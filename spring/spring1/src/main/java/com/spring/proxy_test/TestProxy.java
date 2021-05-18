package com.spring.proxy_test;

import java.lang.reflect.Proxy;
import java.util.logging.Handler;

public class TestProxy {
    public static void main(String[] args) {
        MyHandler myHandler = new MyHandler(new ProxySourceImpl());
        ProxySource proxySource = (ProxySource) Proxy.newProxyInstance(ProxySourceImpl.class.getClassLoader(),ProxySourceImpl.class.getInterfaces(),myHandler);
        proxySource.test();
    }
}

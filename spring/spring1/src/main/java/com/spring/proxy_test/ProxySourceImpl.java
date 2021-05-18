package com.spring.proxy_test;

public class ProxySourceImpl implements ProxySource{
    @Override
    public void test() {
        System.out.println("被代理类的逻辑");
    }
}

package com.spring.proxy_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    Object target;

    MyHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before");
        Object res = method.invoke(target, args);
        System.out.println("do something after");
        return null;
    }
}

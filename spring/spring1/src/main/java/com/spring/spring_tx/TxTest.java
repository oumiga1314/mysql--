package com.spring.spring_tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService serviceImpl = context.getBean("accountServiceImpl", AccountService.class);
        serviceImpl.transfer("tom","mark",500);
    }
}

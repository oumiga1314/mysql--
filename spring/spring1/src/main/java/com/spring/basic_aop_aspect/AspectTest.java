package com.spring.basic_aop_aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDaoImp = context.getBean("userDaoImp", IUserDao.class);
        userDaoImp.save();
    }
}

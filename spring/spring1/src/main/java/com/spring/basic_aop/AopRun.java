package com.spring.basic_aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopRun {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDaoImp =context.getBean("userDaoImp",IUserDao.class);
        userDaoImp.save();
    }
}

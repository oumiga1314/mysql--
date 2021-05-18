package com.spring.base_jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcRun {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user = new User("大神");
        userDao.insert(user);
    }
}

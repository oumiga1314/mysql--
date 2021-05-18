package com.spring.basic_aop_aspect;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImp implements IUserDao {
    @Override
    public void save() {
        System.out.println("save......");
    }
}

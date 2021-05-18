package com.spring.basic_aop;

import com.spring.base_jdbc.User;

public class UserDaoImp implements IUserDao {
    @Override
    public void save() {
        System.out.println("save......");
    }
}

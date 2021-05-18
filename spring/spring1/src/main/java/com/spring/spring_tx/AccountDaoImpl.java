package com.spring.spring_tx;

import jdk.nashorn.internal.runtime.regexp.JdkRegExp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
    @Override
    public void outMoney(String out, int money) {
        String sql ="update account set money=money-? where name =?";
        this.getJdbcTemplate().update(sql,money,out);
    }

    @Override
    public void inMoney(String in, int money) {
        String sql ="update account set money=money+? where name =?";
        this.getJdbcTemplate().update(sql,money,in);
    }
}

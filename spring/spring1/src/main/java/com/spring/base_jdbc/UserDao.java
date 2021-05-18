package com.spring.base_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

//数据访问操作
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    public void  insert(){}
    public void delete(){}
    public void insert(User user){
        String sql ="insert into student values(null,?)";
        int result= jdbcTemplate.update(sql,new Object[]{user.getName()});
        System.out.println(result);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

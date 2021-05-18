package com.spring.spring_tx;

public interface AccountDao {
    //转出方法
    public void outMoney(String out,int money);
    //转入方法
    public void inMoney(String in,int money);
}

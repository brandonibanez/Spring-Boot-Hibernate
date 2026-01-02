package com.brandon.aopdemo.dao;


public interface AccountDAO {

    void addAccount();

    void addAccounting(String str);

    String setName(String name);

    String setNameException(String name);

    String getName();

}

package com.brandon.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: Adding an account");
    }

    @Override
    public void addAccounting(String str) {
        System.out.println(getClass() + ": Doing my DB work: Adding accounting");
    }

    @Override
    public String setName(String name) {
        System.out.println(getClass() + ": Setting account name to " + name);
        this.name = name;
        return this.name;
    }

    @Override
    public String setNameException(String name) {
        System.out.println(getClass() + ": Setting account name to " + name);
        throw new RuntimeException("Just throwing an exception from setNameException");
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": Getting account name");
        return this.name;
    }

}

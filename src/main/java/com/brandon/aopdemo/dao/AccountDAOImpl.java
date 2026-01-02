package com.brandon.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

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
        return name;
    }

    @Override
    public void getName() {
        System.out.println(getClass() + ": Getting account name");
    }

}

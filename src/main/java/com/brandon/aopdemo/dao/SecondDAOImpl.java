package com.brandon.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class SecondDAOImpl implements SecondDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: Adding an account from SecondDAO");
    }

}

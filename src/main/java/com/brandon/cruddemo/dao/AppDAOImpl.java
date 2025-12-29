package com.brandon.cruddemo.dao;

import org.springframework.transaction.annotation.Transactional;

import com.brandon.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;

public class AppDAOImpl implements AppDAO {

    private final EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

}

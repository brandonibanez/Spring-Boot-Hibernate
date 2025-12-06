package com.brandon.cruddemo.dao;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.stereotype.Repository;

import com.brandon.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    public List<Student> retrieveStudents() {
        TypedQuery<Student> theQuery = 
            entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = 
            entityManager.createQuery("FROM Student s WHERE s.lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

}

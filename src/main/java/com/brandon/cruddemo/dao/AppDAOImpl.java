package com.brandon.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brandon.cruddemo.entity.Course;
import com.brandon.cruddemo.entity.Instructor;
import com.brandon.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
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

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        if (tempInstructor != null) {
            entityManager.remove(tempInstructor);
        }
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        if (tempInstructorDetail != null) {
            // Break bi-directional link
            if (tempInstructorDetail.getInstructor() != null) {
                tempInstructorDetail.getInstructor().setInstructorDetail(null);
            }
            entityManager.remove(tempInstructorDetail);
        }
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        return entityManager.createQuery("SELECT c FROM Course c WHERE c.instructor.id = :instructorId", Course.class)
                .setParameter("instructorId", theId)
                .getResultList();
    }

    @Override
    public Instructor findInstructorIdJoinFetch(int theId) {
        return entityManager.createQuery(
                "SELECT i FROM Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :instructorId", Instructor.class)
                .setParameter("instructorId", theId)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

}

package com.brandon.cruddemo.dao;

import java.util.List;

import com.brandon.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(int theId);
    List<Student> retrieveStudents();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    Student delete(int theId);

}

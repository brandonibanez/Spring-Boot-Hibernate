package com.brandon.cruddemo.dao;

import com.brandon.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(int theId);

}

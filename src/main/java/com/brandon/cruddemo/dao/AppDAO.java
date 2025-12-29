package com.brandon.cruddemo.dao;

import com.brandon.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

}

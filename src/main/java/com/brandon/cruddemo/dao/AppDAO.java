package com.brandon.cruddemo.dao;

import com.brandon.cruddemo.entity.Instructor;
import com.brandon.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

}

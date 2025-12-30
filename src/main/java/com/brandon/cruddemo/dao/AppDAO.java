package com.brandon.cruddemo.dao;

import java.util.List;

import com.brandon.cruddemo.entity.Course;
import com.brandon.cruddemo.entity.Instructor;
import com.brandon.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

}

package com.brandon.cruddemo.dao;

import java.util.List;

import com.brandon.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

}

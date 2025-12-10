package com.brandon.cruddemo.dao;

import java.util.List;

import com.brandon.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}

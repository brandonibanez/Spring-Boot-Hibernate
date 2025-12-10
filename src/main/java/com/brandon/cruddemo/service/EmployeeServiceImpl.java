package com.brandon.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brandon.cruddemo.dao.EmployeeDAO;
import com.brandon.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}

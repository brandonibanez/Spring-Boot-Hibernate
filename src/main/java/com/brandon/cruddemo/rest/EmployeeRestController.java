package com.brandon.cruddemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.cruddemo.entity.Employee;
import com.brandon.cruddemo.service.EmployeeService;

import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ObjectNode;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee theEmployee = employeeService.save(employee);
        return theEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
            @RequestBody Map<String, Object> patchPayload) {

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = applyPatch(patchPayload, tempEmployee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    private Employee applyPatch(Map<String, Object> patchPayload, Employee tempEmployee) {

        // Convert employee object to a JSON object node
        ObjectNode employeeNode = jsonMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = jsonMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return jsonMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee tempEmployee = employeeService.findById(id);

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }

}

package com.criteria.service;

import com.criteria.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee createEmployee(Employee employee);

    List<Employee> findByNameAndDepartment(String name, String department);
}

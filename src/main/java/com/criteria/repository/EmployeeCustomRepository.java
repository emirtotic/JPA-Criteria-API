package com.criteria.repository;

import com.criteria.model.Employee;

import java.util.List;

public interface EmployeeCustomRepository {
    public List<Employee> findAllByNameAndDepartment(String name, String department);
}

package com.criteria.service;

import com.criteria.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee createEmployee(Employee employee);

    List<Employee> findByNameAndDepartment(String name, String department);

    List<Employee> findAllWithSpecifications(Specification specification);
}

package com.criteria.service.impl;

import com.criteria.model.Employee;
import com.criteria.repository.EmployeeRepository;
import com.criteria.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByNameAndDepartment(String name, String department) {
        return employeeRepository.findAllByNameAndDepartment(name, department);
    }

    @Override
    public List<Employee> findAllWithSpecifications(Specification specification) {
        return employeeRepository.findAll(specification);
    }
}

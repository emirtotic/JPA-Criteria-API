package com.criteria.repository;

import com.criteria.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>,
        EmployeeCustomRepository,
        JpaSpecificationExecutor<Employee> {

    List<Employee> findAllByNameAndDepartment(String name, String department);
}

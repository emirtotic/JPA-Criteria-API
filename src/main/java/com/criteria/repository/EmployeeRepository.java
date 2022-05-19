package com.criteria.repository;

import com.criteria.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeCustomRepository {

    List<Employee> findAllByNameAndDepartment(String name, String department);
}

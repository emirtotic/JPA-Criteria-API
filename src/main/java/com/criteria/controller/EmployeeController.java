package com.criteria.controller;

import com.criteria.model.Employee;
import com.criteria.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{name}/{department}")
    public ResponseEntity<List<Employee>> findAllByNameAndDepartment(@PathVariable(name = "name") String name,
                                                                     @PathVariable(name = "department") String department) {
        return new ResponseEntity<>(employeeService.findByNameAndDepartment(name, department), HttpStatus.OK);
    }

}

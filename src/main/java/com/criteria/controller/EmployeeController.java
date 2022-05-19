package com.criteria.controller;

import com.criteria.model.Employee;
import com.criteria.service.EmployeeService;
import static com.criteria.specification.EmployeeSpecification.*;
import lombok.RequiredArgsConstructor;
import static org.springframework.data.jpa.domain.Specification.*;
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

//    @GetMapping("/{name}/{department}")
//    public ResponseEntity<List<Employee>> findAllByNameAndDepartment(@PathVariable(name = "name") String name,
//                                                                     @PathVariable(name = "department") String department) {
//        return new ResponseEntity<>(employeeService.findByNameAndDepartment(name, department), HttpStatus.OK);
//    }

    @GetMapping("/{name}/{department}")
    public ResponseEntity<List<Employee>> findAllByNameAndDepartment(@PathVariable(name = "name") String name,
                                                                     @PathVariable(name = "department") String department) {
        return new ResponseEntity<>(
                employeeService.findAllWithSpecifications(
                        where(hasName(name).and(hasDepartment(department)))), HttpStatus.OK);
    }

    @GetMapping("/{surname}")
    public ResponseEntity<List<Employee>> findAllByNameContainsSurname(@PathVariable(name = "surname") String surname) {

        return new ResponseEntity<>(
                employeeService.findAllWithSpecifications(
                        where(containsSurname(surname))), HttpStatus.OK);
    }

}

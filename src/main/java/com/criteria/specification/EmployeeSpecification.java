package com.criteria.specification;

import com.criteria.model.Employee;
import com.criteria.model.Employee_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.NAME), name);
        });
    }

    public static Specification<Employee> containsSurname(String surname) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Employee_.SURNAME), "%" + surname + "%");
        });
    }

    public static Specification<Employee> hasDepartment(String department) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.DEPARTMENT), department);
        });
    }

}

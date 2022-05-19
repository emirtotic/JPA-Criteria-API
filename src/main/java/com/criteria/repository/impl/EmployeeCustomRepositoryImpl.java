package com.criteria.repository.impl;

import com.criteria.model.Employee;
import com.criteria.model.Employee_;
import com.criteria.repository.EmployeeCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAllByNameAndDepartment(String name, String department) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();

        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        Predicate namePredicate = criteriaBuilder.equal(employeeRoot.get(Employee_.NAME), name);
        Predicate departmentPredicate = criteriaBuilder.equal(employeeRoot.get(Employee_.DEPARTMENT), department);

        criteriaQuery.where(namePredicate, departmentPredicate);
        criteriaQuery.select(employeeRoot);

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}

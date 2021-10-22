package com.jdlm.web.app.webapp.repository;

import java.util.List;

import com.jdlm.web.app.webapp.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee,Long>{
    Employee findByEmployeeId(String employeeId);
    List<Employee> findByLastName(String lastName);
}

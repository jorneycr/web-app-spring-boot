package com.jdlm.web.app.webapp.repository;

import java.util.List;

import com.jdlm.web.app.webapp.model.Employee;
import com.jdlm.web.app.webapp.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee,Long>{
    Employee findByEmployeeid(String employeeid);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByRole(Role role);
}

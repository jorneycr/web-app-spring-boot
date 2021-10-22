package com.jdlm.web.app.webapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jdlm.web.app.webapp.model.Employee;
import com.jdlm.web.app.webapp.repository.IEmployeeJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    
    @Autowired
    private IEmployeeJpaRepository repoEmplo;

    @Test
    public void saveEmployee(){
        Employee emplo1 = new Employee("John", "Smith", "empl1");
        Employee emplo2 = new Employee("Daniel", "Smith", "empl2");

        repoEmplo.save(emplo1);
        repoEmplo.save(emplo2);

        repoEmplo.flush();

        assertEquals(2, repoEmplo.findAll().size());
    }
}

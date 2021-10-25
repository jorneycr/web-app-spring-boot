package com.jdlm.web.app.webapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jdlm.web.app.webapp.dto.EmployeeDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeServiceTest {

    private static final Object JUAN = "Juan";
    private static final Object MARIA = "Maria";

    @Test
    public void employeeWithLombokTest() {
        EmployeeDTO emp1 = new EmployeeDTO();
        EmployeeDTO emp2 = new EmployeeDTO();
        emp1.setId(Long.valueOf(1));
        emp1.setFirstName("Juan");
        emp2.setId(Long.valueOf(1));
        emp2.setFirstName("Maria");
        assertEquals(emp1.getFirstName(),JUAN);
        assertEquals(emp2.getFirstName(), MARIA);

    }

}

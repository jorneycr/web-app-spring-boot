package com.jdlm.web.app.webapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import com.jdlm.web.app.webapp.dto.RoleDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleServiceTest {
    /**
     *
     */
    private static final String ADMIN = "ADMIN";
    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void contraintsValidationExceptionTest() {

        assertThrows(ConstraintViolationException.class, () -> {
            roleService.save(new RoleDto(null));
        });
        assertThrows(ConstraintViolationException.class, () -> {
            roleService.save(new RoleDto(""));
        });
        assertThrows(ConstraintViolationException.class, () -> {
            roleService.save(new RoleDto("1234567890123456"));
        });

    }

    @Test
    public void createRoleOk() {
        RoleDto roleDto = roleService.save(new RoleDto(ADMIN));
        assertNotNull(roleDto);
        assertEquals(ADMIN, roleDto.getName());
        assertNotNull(roleDto.getId());
    }
}

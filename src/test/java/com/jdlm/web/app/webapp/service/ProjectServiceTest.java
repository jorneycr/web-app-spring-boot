package com.jdlm.web.app.webapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jdlm.web.app.webapp.dto.ProjectDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProjectServiceTest {
    
    private static final @NotBlank @Size(max = 15) String PROJECT = "PROJECT";
    @Autowired
    private ProjectServiceImpl projectService;

    @Test
    public void contraintsValidationExceptionTest(){
        assertThrows(ConstraintViolationException.class, ()->{
            projectService.save(new ProjectDTO(null));
        });
        assertThrows(ConstraintViolationException.class, ()->{
            projectService.save(new ProjectDTO(""));
        });
        assertThrows(ConstraintViolationException.class, ()->{
            projectService.save(new ProjectDTO("1234567890123456"));
        });
    }

    @Test
    public void createProjectOk() {
        ProjectDTO projectDto = projectService.save(new ProjectDTO(PROJECT));
        assertNotNull(projectDto);
        assertEquals(PROJECT, projectDto.getName());
        assertNotNull(projectDto.getId());
    }
}

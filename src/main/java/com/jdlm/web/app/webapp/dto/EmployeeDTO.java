package com.jdlm.web.app.webapp.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class EmployeeDTO {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 10)
    private String employeeid;
    @NotBlank
    @Size(max = 25)
    private String firstName;
    @NotBlank
    @Size(max = 25)
    private String lastName;
    @NotNull
    private RoleDto role;
    private List<ProjectDTO> projects;

    public EmployeeDTO() {
    }

    public EmployeeDTO(@NotBlank @Size(max = 10) String employeeid, @NotBlank @Size(max = 25) String firstName,
            @NotBlank @Size(max = 25) String lastName, @NotNull RoleDto role, List<ProjectDTO> projects) {
        this.employeeid = employeeid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.projects = projects;
    }

}

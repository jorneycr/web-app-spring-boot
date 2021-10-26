package com.jdlm.web.app.webapp.mvc.form;

import java.util.List;

import com.jdlm.web.app.webapp.dto.EmployeeDTO;
import com.jdlm.web.app.webapp.dto.ProjectDTO;
import com.jdlm.web.app.webapp.dto.RoleDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeForm {
    private EmployeeDTO employee;
    private RoleDto role;
    private List<RoleDto> roles;
    private List<ProjectDTO> projects;
}

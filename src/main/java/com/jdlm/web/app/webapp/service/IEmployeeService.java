package com.jdlm.web.app.webapp.service;

import java.util.List;

import javax.validation.Valid;

import com.jdlm.web.app.webapp.dto.EmployeeDTO;

public interface IEmployeeService {
    public EmployeeDTO save(@Valid EmployeeDTO employee);
    public EmployeeDTO get(Long id);
    public List<EmployeeDTO> getAll();
    public void delete(Long id);
}

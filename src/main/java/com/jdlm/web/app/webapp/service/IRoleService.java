package com.jdlm.web.app.webapp.service;

import java.util.List;

import javax.validation.Valid;

import com.jdlm.web.app.webapp.dto.RoleDto;

public interface IRoleService {

    public RoleDto save(@Valid RoleDto role);
    public RoleDto get(Long id);
    public List<RoleDto> getAll();
    public void delete(Long id);
}

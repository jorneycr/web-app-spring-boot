package com.jdlm.web.app.webapp.mvc.converter;

import com.jdlm.web.app.webapp.dto.RoleDto;
import com.jdlm.web.app.webapp.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToRoleDTOConverter implements Converter<String, RoleDto>{

    @Autowired
    IRoleService roleService;

    @Override
    public RoleDto convert(String id) {
        RoleDto role = roleService.get(Long.valueOf(id));
        return role;
    }
    
}

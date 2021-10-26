package com.jdlm.web.app.webapp.mvc.converter;

import com.jdlm.web.app.webapp.dto.ProjectDTO;
import com.jdlm.web.app.webapp.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToProjectDTOConverter implements Converter<String,ProjectDTO>{
    @Autowired
    IProjectService projectService;

    @Override
    public ProjectDTO convert(String id) {
        ProjectDTO projectDTO = projectService.get(Long.valueOf(id));
        return projectDTO;
    }
}

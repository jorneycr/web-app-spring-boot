package com.jdlm.web.app.webapp.service;

import java.util.List;

import javax.validation.Valid;

import com.jdlm.web.app.webapp.dto.ProjectDTO;

public interface IProjectService {
    public ProjectDTO save(@Valid ProjectDTO project);
    public ProjectDTO get(Long id);
    public List<ProjectDTO> getAll();
    public void delete(Long id);
}

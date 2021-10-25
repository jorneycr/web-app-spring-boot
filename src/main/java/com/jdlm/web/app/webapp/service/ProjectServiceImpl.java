package com.jdlm.web.app.webapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.jdlm.web.app.webapp.dto.ProjectDTO;
import com.jdlm.web.app.webapp.model.Project;
import com.jdlm.web.app.webapp.repository.IProjectJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectJpaRepository repoProject;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO save(@Valid ProjectDTO project) {
        Project projectEntity = modelMapper.map(project, Project.class);
        projectEntity = repoProject.save(projectEntity);
        return modelMapper.map(projectEntity, ProjectDTO.class);
    }

    @Override
    public ProjectDTO get(Long id) {
        Project projectEntity = repoProject.getById(id);
        ProjectDTO projectDTO = modelMapper.map(projectEntity, ProjectDTO.class);
        return projectDTO;
    }

    @Override
    public List<ProjectDTO> getAll() {
        List<Project> listRoleEntity = repoProject.findAll();
        List<ProjectDTO> listRoleDto = listRoleEntity.stream().map(role -> modelMapper.map(role, ProjectDTO.class))
                .collect(Collectors.toList());
        return listRoleDto;
    }

    @Override
    public void delete(Long id) {
        repoProject.deleteById(id);
    }

}

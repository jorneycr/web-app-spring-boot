package com.jdlm.web.app.webapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.jdlm.web.app.webapp.dto.RoleDto;
import com.jdlm.web.app.webapp.model.Role;
import com.jdlm.web.app.webapp.repository.IRoleJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleDto save(@Valid RoleDto role) {
        Role roleEntity = modelMapper.map(role, Role.class);
        roleEntity = repoRole.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDto.class);
    }

    @Override
    public RoleDto get(Long id) {
        Role roleEntity = repoRole.getById(id);
        RoleDto roleDto = modelMapper.map(roleEntity, RoleDto.class);
        return roleDto;
    }

    @Override
    public List<RoleDto> getAll() {
        List<Role> listRoleEntity = repoRole.findAll();
        List<RoleDto> listRoleDto = listRoleEntity.stream().map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
        return listRoleDto;
    }

    @Override
    public void delete(Long id) {
        repoRole.deleteById(id);

    }

}

package com.jdlm.web.app.webapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.jdlm.web.app.webapp.dto.EmployeeDTO;
import com.jdlm.web.app.webapp.model.Employee;
import com.jdlm.web.app.webapp.repository.IEmployeeJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeJpaRepository employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO save(@Valid EmployeeDTO employee) {
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        employeeEntity = employeeRepo.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO get(Long id) {
        Employee employeeEntity = employeeRepo.getById(id);
        EmployeeDTO employeeDto = modelMapper.map(employeeEntity, EmployeeDTO.class);
        return employeeDto;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> listEmployeeEntity = employeeRepo.findAll();
        List<EmployeeDTO> listEmployeeDto = listEmployeeEntity.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
        return listEmployeeDto;
    }

    @Override
    public void delete(Long id) {
        employeeRepo.deleteById(id);        
    }
    
}

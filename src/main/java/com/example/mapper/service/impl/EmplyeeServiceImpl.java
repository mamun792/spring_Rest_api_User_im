package com.example.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.dto.CreateEmployeeRequest;
import com.example.mapper.dto.EmployeeDTO;

import com.example.mapper.entity.Employee;
import com.example.mapper.repository.DepartmentRepository;
import com.example.mapper.repository.EmployeeRepository;
import com.example.mapper.service.EmplyeService;
import com.example.mapper.util.EmplyeeMapper;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmplyeeServiceImpl implements EmplyeService {
    @Autowired
    private EmployeeRepository emplyeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public void save(CreateEmployeeRequest createEmplyeRequest) {

        Employee employee = new Employee();
        employee.setName(createEmplyeRequest.getName());
        if (createEmplyeRequest.getDepartmentId() == null) {
            throw new RuntimeException("Department not found" + createEmplyeRequest.getDepartmentId());
        }
        employee.setDepartment(departmentRepository.findById(createEmplyeRequest.getDepartmentId()).get());
        emplyeeRepository.save(employee);

    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> emplye = emplyeeRepository.findAll();
        // return //method reference
        // emplye.stream().map(EmplyeeMapper::maToDto).collect(Collectors.toList());
        return emplye.stream().map(e -> EmplyeeMapper.maToDto(e)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee emplye = emplyeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emplye not found" + id));

        return EmplyeeMapper.maToDto(emplye);
    }

    @Transactional
    @Override
    public EmployeeDTO update(Long id, CreateEmployeeRequest createEmplyeRequest) {
        Employee emplye = emplyeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emplye not found" + id));
        emplye.setName(createEmplyeRequest.getName());

        if (createEmplyeRequest.getDepartmentId() != null) {
            emplye.setDepartment(departmentRepository.findById(createEmplyeRequest.getDepartmentId()).get());
            emplyeeRepository.save(emplye);
        }
        emplyeeRepository.save(emplye);
        return EmplyeeMapper.maToDto(emplye);
    }

    @Override
    public void deleteById(Long id) {
        emplyeeRepository.deleteById(id);

    }

    // query custom
    @Override
    public List<EmployeeDTO> getAllEmplyees() {
        List<Employee> emplye = emplyeeRepository.getAllEmplyees();
        return emplye.stream().map(e -> EmplyeeMapper.maToDto(e)).collect(Collectors.toList());
    }

}
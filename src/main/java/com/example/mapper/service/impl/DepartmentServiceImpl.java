package com.example.mapper.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mapper.dto.CreateDepartmentRequest;
import com.example.mapper.dto.DepartmentDTO;
import com.example.mapper.entity.Department;
import com.example.mapper.entity.Employee;
import com.example.mapper.repository.DepartmentRepository;
import com.example.mapper.repository.EmployeeRepository;
import com.example.mapper.service.DepartmentService;
import com.example.mapper.util.DepartmentMapper;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> department = departmentRepository.findAll();
        return department.stream().map(DepartmentMapper::mapToDto).collect(Collectors.toList());

    }

    @Override
    public DepartmentDTO findById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found" + id));

        return DepartmentMapper.mapToDto(department);
    }

    @Transactional
    @Override

    public void save(CreateDepartmentRequest createDepartmentRequest) {

        Department department = new Department();
        department.setName(createDepartmentRequest.getName());

        departmentRepository.save(department);
        if (createDepartmentRequest.getEmployees() != null) {

            List<Employee> employees = createDepartmentRequest.getEmployees().stream()
                    .map(employeeRequest -> {
                        Employee employee = new Employee();
                        employee.setName(employeeRequest.getName());
                        employee.setDepartment(department);
                        return employeeRepository.save(employee);
                    })
                    .collect(Collectors.toList());
            department.setEmployees(employees);
            departmentRepository.save(department);
        }
        departmentRepository.save(department);
    }

    @Transactional
    @Override
    public void update(Long id, CreateDepartmentRequest createDepartmentRequest) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found" + id));
        department.setName(createDepartmentRequest.getName());
        departmentRepository.save(department);
        if (createDepartmentRequest.getEmployees() != null) {
            List<Employee> employees = createDepartmentRequest.getEmployees().stream()
                    .map(employeeRequest -> {
                        Employee employee = new Employee();
                        employee.setName(employeeRequest.getName());
                        employee.setDepartment(department);
                        return employeeRepository.save(employee);
                    })
                    .collect(Collectors.toList());

            department.setEmployees(employees);
            departmentRepository.save(department);
        }
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found" + id));
        departmentRepository.deleteById(id);
    }
}
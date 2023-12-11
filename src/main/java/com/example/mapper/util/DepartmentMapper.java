package com.example.mapper.util;

import java.util.List;

import com.example.mapper.dto.DepartmentDTO;
import com.example.mapper.dto.EmployeeDTO;
import com.example.mapper.entity.Department;

import java.util.stream.Collectors;

public class DepartmentMapper {
    public static DepartmentDTO mapToDto(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());

        List<EmployeeDTO> employeeDTOs = department.getEmployees().stream().map(e -> {
            // way1
            // EmployeeDTO employeeDTO = new EmployeeDTO();
            // employeeDTO.setId(e.getId());
            // employeeDTO.setName(e.getName());
            // return employeeDTO;
            // way2
             return EmplyeeMapper.maToDto(e);
        })
                .collect(Collectors.toList());
        departmentDTO.setEmployees(employeeDTOs);
        return departmentDTO;
    }
}
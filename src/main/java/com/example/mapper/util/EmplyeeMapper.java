package com.example.mapper.util;

import com.example.mapper.dto.EmployeeDTO;
import com.example.mapper.entity.Employee;

public class EmplyeeMapper {
    public static EmployeeDTO maToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;
    }
}
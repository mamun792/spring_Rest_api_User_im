package com.example.mapper.dto;

import com.example.mapper.entity.Department;

public class EmployeeDTO {
    private Long id;
    private String name;

    private Department department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
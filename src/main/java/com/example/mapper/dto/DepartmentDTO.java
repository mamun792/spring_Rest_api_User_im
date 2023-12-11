package com.example.mapper.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private List<EmployeeDTO> employees;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, List<EmployeeDTO> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
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

    public List<EmployeeDTO> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

}
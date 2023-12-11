package com.example.mapper.dto;

import java.util.List;

public class CreateDepartmentRequest {
    private String name;
    private List<CreateEmployeeRequest> employees;

    public CreateDepartmentRequest() {
    }

    public CreateDepartmentRequest(String name, List<CreateEmployeeRequest> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreateEmployeeRequest> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<CreateEmployeeRequest> employees) {
        this.employees = employees;
    }

}
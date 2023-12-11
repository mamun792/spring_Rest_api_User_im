package com.example.mapper.dto;

public class CreateEmployeeRequest {
    private String name;
    private Long departmentId;

    public CreateEmployeeRequest() {
    }

    public CreateEmployeeRequest(String name, Long departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
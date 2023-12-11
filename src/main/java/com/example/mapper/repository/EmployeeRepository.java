package com.example.mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapper.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
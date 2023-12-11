package com.example.mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapper.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
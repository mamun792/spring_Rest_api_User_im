package com.example.mapper.service;

import java.util.List;

import com.example.mapper.dto.CreateDepartmentRequest;
import com.example.mapper.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    List<DepartmentDTO> findAll();

    public void save(CreateDepartmentRequest createDepartmentRequest);

    public DepartmentDTO findById(Long id);

     public void deleteById(Long id);

     public void update(Long id, CreateDepartmentRequest createDepartmentRequest);
}
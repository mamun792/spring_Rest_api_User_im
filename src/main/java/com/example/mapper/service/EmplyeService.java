package com.example.mapper.service;

import java.util.List;

import com.example.mapper.dto.CreateEmployeeRequest;
import com.example.mapper.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmplyeService {
    public void save(CreateEmployeeRequest createEmplyeRequest);

    public List<EmployeeDTO> findAll();

    public EmployeeDTO findById(Long id);

    public EmployeeDTO update(Long id, CreateEmployeeRequest createEmplyeRequest);

    public void deleteById(Long id);
}
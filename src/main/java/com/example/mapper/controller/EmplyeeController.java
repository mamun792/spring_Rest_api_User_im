package com.example.mapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mapper.dto.EmployeeDTO;
import com.example.mapper.service.EmplyeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import com.example.mapper.dto.CreateEmployeeRequest;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/employee")
public class EmplyeeController {
    @Autowired
    private EmplyeService emplyeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> employeeDTOs = emplyeService.findAll();
        return ResponseEntity.ok(employeeDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        try {
            EmployeeDTO employeeDTO = emplyeService.findById(id);
            return ResponseEntity.ok(employeeDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CreateEmployeeRequest createEmplyeRequest) {
        emplyeService.save(createEmplyeRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
            @RequestBody CreateEmployeeRequest createEmplyeRequest) {
        emplyeService.update(id, createEmplyeRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            emplyeService.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
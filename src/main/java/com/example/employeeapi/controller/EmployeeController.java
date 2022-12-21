package com.example.employeeapi.controller;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.service.Impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping
    public ResponseEntity<List<Employee>> findALlEmployees() {
        return employeeServiceImpl.findAllEmployees();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable("id") Integer id
    ) {
        return employeeServiceImpl.deleteEployee(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") Integer id,
            @RequestBody Employee employee
    ) {
        return employeeServiceImpl.updateEmployee(id, employee);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(
            @RequestBody Employee employee
    ) {
        return employeeServiceImpl.saveEmployee(employee);
    }
}

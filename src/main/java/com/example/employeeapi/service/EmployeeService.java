package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity saveEmployee(Employee employee);
    ResponseEntity deleteEployee(Integer id);
    ResponseEntity updateEmployee(Integer employeeId, Employee employee);
    ResponseEntity findAllEmployees();
}

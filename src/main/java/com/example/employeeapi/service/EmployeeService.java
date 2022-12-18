package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    void deleteEployee(Integer id);
    Employee updateEmployee(Integer employeeId, Employee employee);
    List<Employee> findAllEmployees();
}

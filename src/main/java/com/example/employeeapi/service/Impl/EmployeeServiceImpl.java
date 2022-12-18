package com.example.employeeapi.service.Impl;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setContractDate(LocalDate.now());
        return employeeRepository.save(employee);

    }

    @Override
    public void deleteEployee(Integer id) {
        //add validation if employee id exist
        //add log record
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Integer employeeId, Employee employee) {
        //add validations and verifications if employee exists
        Employee employeeSaved = employeeRepository.findById(employeeId).get();
       employeeSaved.setEmail(employee.getEmail());
       employeeSaved.setFirstName(employee.getFirstName());
       employeeSaved.setLastName(employee.getLastName());
       employeeSaved.setContractDate(employee.getContractDate());
       employeeRepository.save(employeeSaved);
       return employeeSaved;
    }

    @Override
    public List<Employee> findAllEmployees() {
        //verify if there is employees in the database
        //add log record
        return employeeRepository.findAll();
    }
}

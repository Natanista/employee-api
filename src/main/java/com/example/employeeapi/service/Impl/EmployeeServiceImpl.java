package com.example.employeeapi.service.Impl;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity saveEmployee(Employee employee) {
        employee.setContractDate(LocalDate.now());
        log.info("Employee saved!");
        ;
        return ResponseEntity.status(201).build();

    }

    @Override
    public ResponseEntity deleteEployee(Integer id) {
        //add validation if employee id exist
        if(employeeRepository.existsById(id)){
            log.info("Employee removed!");
            employeeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity updateEmployee(Integer employeeId, Employee employee) {
        //add validations and verifications if employee exists
        if(employeeRepository.existsById(employeeId)){
            Employee employeeSaved = employeeRepository.findById(employeeId).get();
            employeeSaved.setEmail(employee.getEmail());
            employeeSaved.setFirstName(employee.getFirstName());
            employeeSaved.setLastName(employee.getLastName());
            employeeSaved.setContractDate(employee.getContractDate());
            log.info("Employee updated!");
            employeeRepository.save(employeeSaved);
            return ResponseEntity.ok(employeeSaved);
        }
        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            log.info("Finding all employees...");
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(employees);
    }
}

package com.example.mapping1_many.demo.controller;


import com.example.mapping1_many.demo.NameAndDept;
import com.example.mapping1_many.demo.entity.Employee;
import com.example.mapping1_many.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{employeeId}/assign/{departmentId}")
    public Employee assignToDepartment(@PathVariable Long employeeId, @PathVariable Long departmentId) {
        return employeeService.assignEmployeeToDepartment(employeeId, departmentId);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = employeeService.saveEmployees(employees);
        return ResponseEntity.ok(savedEmployees);
    }

    @GetMapping("/names")
    public List<String> getEmployeeNames() {
        return employeeService.getAllEmployeeNames();
    }

    @GetMapping("/namesAndDept/{id}")
    public NameAndDept getNameAndDept(@PathVariable Long id) {
        return employeeService.getEmpById(id);
    }
}

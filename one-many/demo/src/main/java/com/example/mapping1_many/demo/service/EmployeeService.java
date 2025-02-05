package com.example.mapping1_many.demo.service;

import com.example.mapping1_many.demo.NameAndDept;
import com.example.mapping1_many.demo.entity.Department;
import com.example.mapping1_many.demo.entity.Employee;
import com.example.mapping1_many.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentService departmentService;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee assignEmployeeToDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        Department department = departmentService.getDepartmentById(departmentId);
        Long departmentId1 = department.getId();
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<String> getAllEmployeeNames() {
        return employeeRepository.findAllEmployeeNames();
    }

    public NameAndDept getEmpById(Long empId) {
        return employeeRepository.findEmployeeAndDepartmentNames(empId);

        // Check if the result is not null or empty
        if (result == null || result.isEmpty()) {
            return null; // Or handle as per your application's requirement
        }

        // Create a new NameAndDept object
        NameAndDept nameAndDept = new NameAndDept();

        // Since empId will generally return one row, get the first result
        Object[] obj = result.get(0);

        // Map the result to the NameAndDept fields
        nameAndDept.setEmpName((String) obj[0]);  // Extract empName
        nameAndDept.setEmpDept((String) obj[1]); // Extract deptName

        return nameAndDept;

    }
}


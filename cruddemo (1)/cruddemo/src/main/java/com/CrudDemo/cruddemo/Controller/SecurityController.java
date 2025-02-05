package com.CrudDemo.cruddemo.Controller;

import com.security.springSecurity.Entity.ManagementDetails; // Fixing typo
import com.security.springSecurity.Service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Management")
public class SecurityController {

    @Autowired
    ManagementService managementService;

    @PostMapping("/addEmployee")
    public ManagementDetails addEmployee(@RequestBody ManagementDetails managementDetails) {
        return managementService.addEmployee(managementDetails);
    }

    @PostMapping("/addEmployees")
    public List<ManagementDetails> addEmployees(@RequestBody List<ManagementDetails> managementDetailsList) {
        return managementService.addEmployeeList(managementDetailsList);
    }


    @GetMapping("/getEmployees")
    public List<ManagementDetails> getEmployees() {
        return managementService.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public Optional<ManagementDetails> getEmployeeById(@PathVariable int id) {
        return managementService.getEmployeeById(id);
    }

    @GetMapping("/getEmployee/role/{role}")
    public Optional<ManagementDetails> getEmployeeByRole(@PathVariable String role) {
        return managementService.getEmployeeByRole(role);
    }
}

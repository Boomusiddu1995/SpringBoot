package com.security.springSecurity.Controller;


import com.security.springSecurity.Entity.ManagementDeteils;
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

//    @GetMapping("/getEmployeeDetails")
//    public String getEmployeeDetails(){
//        return "Employee Details";
//    } // Application property ----> user,pwd

    @PostMapping("/addEmployee")
    public ManagementDeteils addEmployee(@RequestBody ManagementDeteils managementDeteils){
        return managementService.addEmployees(managementDeteils);
    }

    @PostMapping("/addEmployees")
    public List<ManagementDeteils> addEmployees(@RequestBody ManagementDeteils managementDeteils){
        return managementService.addEmployeeList((List<ManagementDeteils>) managementDeteils);
    }

    @GetMapping("/getEmployees")
    public List<ManagementDeteils> getEmployees(){
        return managementService.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public Optional<ManagementDeteils> getEmployeeById(@PathVariable int id){
        return managementService.getEmployeeById(id);
    }

    @GetMapping("/getEmployee/role")
    public Optional<ManagementDeteils> getEmployeeByRole(@PathVariable String role){
        return managementService.getEmployeeByRole(role);
    }

}

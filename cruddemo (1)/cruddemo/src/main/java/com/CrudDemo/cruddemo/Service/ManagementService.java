package com.CrudDemo.cruddemo.Service;

import com.security.springSecurity.Entity.ManagementDetails; // Fixed typo
import com.security.springSecurity.Repository.ManagementRepository; // Correct repository name
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagementService {

    @Autowired
    ManagementRepo managementRepo;


    public ManagementDetails addEmployees(ManagementDetails managementDetails) {
        return managementRepo.save(managementDetails);
    }


    public List<ManagementDetails> addEmployeeList(List<ManagementDetails> managementDetails) {
        return managementRepo.saveAll(managementDetails);
    }


    public List<ManagementDetails> getAllEmployees() {
        return managementRepo.findAll();
    }


    public Optional<ManagementDetails> getEmployeeById(int id) {
        return managementRepo.findById(id);
    }


    public Optional<ManagementDetails> getEmployeeByRole(String role) {
        return managementRepo.findByRole(role);
    }
}

package com.security.springSecurity.Service;

import com.security.springSecurity.Entity.ManagementDeteils;
import com.security.springSecurity.Repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagementService {

    @Autowired
    ManagementRepository managementRepository;

    public ManagementDeteils addEmployees(ManagementDeteils managementDeteils) {
        return managementRepository.save(managementDeteils);
    }

    public List<ManagementDeteils> addEmployeeList(List<ManagementDeteils> managementDeteils) {
        return managementRepository.saveAll(managementDeteils);
    }

    public List<ManagementDeteils> getAllEmployees() {
        return managementRepository.findAll();
    }

    public Optional<ManagementDeteils> getEmployeeById(int id) {
        return managementRepository.findById(id);
    }

    public Optional<ManagementDeteils> getEmployeeByRole(String role){
        return managementRepository.findByRole(role);
    }
}

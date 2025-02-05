package com.CrudDemo.cruddemo.Repo;


import com.security.springSecurity.Entity.ManagementDeteils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagementRepo extends JpaRepository<ManagementDetails,Integer> {

    Optional<ManagementDetails> findByRole(String role);

}

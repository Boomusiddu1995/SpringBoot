package com.security.springSecurity.Repository;


import com.security.springSecurity.Entity.ManagementDeteils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagementRepository extends JpaRepository<ManagementDeteils,Integer> {

    Optional<ManagementDeteils> findByRole(String role);

}

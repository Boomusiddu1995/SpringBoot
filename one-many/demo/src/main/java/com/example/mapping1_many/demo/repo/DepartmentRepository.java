package com.example.mapping1_many.demo.repo;


import com.example.mapping1_many.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

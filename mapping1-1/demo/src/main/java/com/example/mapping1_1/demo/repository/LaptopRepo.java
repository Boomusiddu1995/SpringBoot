package com.example.mapping1_1.demo.repository;

import com.example.mapping1_1.demo.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {
}
package com.example.JPAdemo.ProductRepo;


import com.example.JPAdemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{

}

package com.example.product_app.Repo;

import com.example.product_app.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long>{

}

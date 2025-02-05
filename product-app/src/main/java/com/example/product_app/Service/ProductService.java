package com.example.product_app.Service;

import com.example.product_app.Entity.Product;
import com.example.product_app.Repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public String addProducts(List<Product> products){
        productRepo.saveAll(products);
        return "products Added Successfully....";
    }

    public String addProduct(Product product){
        productRepo.save(product);
        return "Product Added Successfully";
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

   public Product getProductById(Long id){
        return productRepo.findById(id).orElse(new Product());
    }

    public String updateProduct(Product product){
        productRepo.save(product);
        return "updated";
    }

    public String deleteProduct(Long id){
        productRepo.deleteById(id);
        return "Deleted";
    }

    public String deleteAllProducts(){
        productRepo.deleteAll();
        return "Deleted All";
    }
}

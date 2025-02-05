package com.example.JPAdemo.ProductService;

import com.example.JPAdemo.Entity.Product;
import com.example.JPAdemo.ProductRepo.ProductRepo;
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
        return "Products Added Successfully.....";
    }

    public String addProduct(Product product) {
        productRepo.save(product);
        return "Product Added Successfully";
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public String updateProduct(Product product) {
        productRepo.save(product);
        return "Updated";

    }

    public String deleteProduct(int id) {
        productRepo.deleteById(id);
        return "Deleted";
    }

    public String deleteAllProducts() {
        productRepo.deleteAll();
        return "Deleted All ";
    }
}

package com.example.JPAdemo.ProductController;


import com.example.JPAdemo.Entity.Product;
import com.example.JPAdemo.ProductService.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProducts")
    public String addProducts(@RequestBody List<Product> product){
        return productService.addProducts(product);
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable ("id") int id){
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @DeleteMapping("/deleteAllProducts")
    public String deleteAllProducts(){
        return productService.deleteAllProducts();
    }
}

package com.example.product_app.Controller;

import com.example.product_app.Entity.Product;
import com.example.product_app.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

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

    @GetMapping("/getProducts/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long Id){
        return productService.deleteProduct(Id);
    }

    @DeleteMapping("/deleteAllProducts")
    public String deleteAllProducts(){
        return productService.deleteAllProducts();
    }
}

package com.ecom.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecom.product.model.Product;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        service.save(product);
        return "Product saved successfully!";
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable int id) {
        service.update(product, id);
        return "Product updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteById(id);
        return "Product deleted successfully!";
    }
}

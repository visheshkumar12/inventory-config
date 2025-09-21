package com.ecom.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.product.irepository.ProductRepository;
import com.ecom.product.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public int save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public int update(Product product, int id) {
        return productRepository.update(product, id);
    }

    public int deleteById(int id) {
        return productRepository.deleteById(id);
    }
}

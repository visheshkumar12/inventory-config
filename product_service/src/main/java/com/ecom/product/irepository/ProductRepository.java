package com.ecom.product.irepository;

import java.util.List;
import com.ecom.product.model.Product;

public interface ProductRepository {
    int save(Product product);
    List<Product> findAll();
    Product findById(int id);
    int update(Product product, int id);
    int deleteById(int id);
}

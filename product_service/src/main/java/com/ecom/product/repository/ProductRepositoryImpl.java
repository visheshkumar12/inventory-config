package com.ecom.product.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ecom.product.irepository.ProductRepository;
import com.ecom.product.model.Product;

@Repository(value = "ProductRepositoryImpl")
public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Product product) {
        return jdbcTemplate.update(
            "INSERT INTO product(name, price) VALUES(?, ?)",
            product.getName(), product.getPrice()
        );
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM product",
                BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public Product findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    @Override
    public int update(Product product, int id) {
        return jdbcTemplate.update(
            "UPDATE product SET name=?, price=? WHERE id=?",
            product.getName(), product.getPrice(), id
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM product WHERE id=?", id);
    }
}

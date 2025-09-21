package com.ecom.mvc.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecom.mvc.irepository.InventoryRepository;
import com.ecom.mvc.model.Inventory;

@Repository(value = "InventoryRepositoryImpl")
public class InventoryRepositoryImpl implements InventoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InventoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    @Override
    public List<Inventory> getAllInventory() {
        return jdbcTemplate.query("SELECT * FROM inventory", new InventoryRowMapper());
    }

    
    @Override
    public Inventory getInventoryById(Long id) {
        String sql = "SELECT * FROM inventory WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new InventoryRowMapper());
    }

    @Override
    public int addInventory(Inventory inventory) {
        String sql = "INSERT INTO inventory (quantity) VALUES (?)";
        return jdbcTemplate.update(sql, inventory.getQuantity());
    }

    
    @Override
    public int updateInventory(Inventory inventory) {
        String sql = "UPDATE inventory SET quantity = ? WHERE id = ?";
        return jdbcTemplate.update(sql, inventory.getQuantity(), inventory.getId());
    }

    
    @Override
    public int deleteInventory(Long id) {
        String sql = "DELETE FROM inventory WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

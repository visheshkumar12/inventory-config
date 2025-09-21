package com.ecom.mvc.respository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecom.mvc.model.Inventory;

public class InventoryRowMapper implements RowMapper<Inventory> {
    @Override
    public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setId(rs.getLong("id"));
        inventory.setQuantity(rs.getInt("quantity"));
        return inventory;
    }
}

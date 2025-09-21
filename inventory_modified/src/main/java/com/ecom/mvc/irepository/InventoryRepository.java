package com.ecom.mvc.irepository;

import java.util.List;

import com.ecom.mvc.model.Inventory;

public interface InventoryRepository {
    List<Inventory> getAllInventory();
    Inventory getInventoryById(Long id);
    int addInventory(Inventory inventory);
    int updateInventory(Inventory inventory);
    int deleteInventory(Long id);
}

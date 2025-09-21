package com.ecom.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.mvc.dto.InventoryDTO;
import com.ecom.mvc.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    
    @PostMapping
    public String addInventory(@RequestBody InventoryDTO dto) {
        int result = inventoryService.addInventory(dto);
        return result > 0 ? "Inventory added successfully" : "Failed to add inventory";
    }

   
    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    
    @GetMapping("/{id}")
    public InventoryDTO getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("/{id}")
    public String updateInventory(@PathVariable Long id, @RequestBody InventoryDTO dto) {
        int result = inventoryService.updateInventory(id, dto);
        return result > 0 ? "Inventory updated successfully" : "Failed to update inventory";
    }

   
    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {
        int result = inventoryService.deleteInventory(id);
        return result > 0 ? "Inventory deleted successfully" : "Failed to delete inventory";
    }
}

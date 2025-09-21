package com.ecom.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ecom.mvc.dto.InventoryDTO;
import com.ecom.mvc.irepository.InventoryRepository;
import com.ecom.mvc.model.Inventory;

@Service(value = "InventoryService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    
    private  final RestClient _productRestClient;


    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, ModelMapper modelMapper,RestClient.Builder restClientbBuilder) {
        this.inventoryRepository = inventoryRepository;
        this.modelMapper = modelMapper;
        _productRestClient=
        restClientbBuilder.baseUrl("http://localhost:9003/products").build();
    }

   
    public List<InventoryDTO> getAllInventory() {
        List<Inventory> inventories = inventoryRepository.getAllInventory();
        List<InventoryDTO> dtos = new ArrayList<>();
        for (Inventory inv : inventories) {
            InventoryDTO dto = modelMapper.map(inv, InventoryDTO.class);
            dtos.add(dto);
        }
        return dtos;
    }

    
    public InventoryDTO getInventoryById(Long id) {
        Inventory inventory = inventoryRepository.getInventoryById(id);
        return modelMapper.map(inventory, InventoryDTO.class);
    }


    public int addInventory(InventoryDTO dto) {
        Inventory inventory = modelMapper.map(dto, Inventory.class);
        return inventoryRepository.addInventory(inventory);
    }

    public int updateInventory(Long id, InventoryDTO dto) {
        Inventory inventory = modelMapper.map(dto, Inventory.class);
        inventory.setId(id); 
        return inventoryRepository.updateInventory(inventory);
    }

    
    public int deleteInventory(Long id) {
        return inventoryRepository.deleteInventory(id);
    }
}

package com.ecom.mvc.controller;

import org.springframework.web.bind.annotation.*;
import com.ecom.mvc.dto.ProductDTO;
import com.ecom.mvc.service.InventoryProductClient;

@RestController
@RequestMapping("/inventory")
public class InventoryProductController {

    private final InventoryProductClient client;

    public InventoryProductController(InventoryProductClient client) {
        this.client = client;
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable int id) {
        return client.getProductDetails(id);
    }
}

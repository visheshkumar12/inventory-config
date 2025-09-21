package com.ecom.mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ecom.mvc.dto.ProductDTO;

@Service
public class InventoryProductClient {

    private final RestTemplate restTemplate;

    public InventoryProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductDetails(int productId) {
        String url = "http://localhost:8081/products/" + productId;
        return restTemplate.getForObject(url, ProductDTO.class);
    }
}

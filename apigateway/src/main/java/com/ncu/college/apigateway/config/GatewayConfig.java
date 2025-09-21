package com.ncu.college.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder)
    {
        return builder.routes()
            .route("inventoryservice", r -> r.path("/inventory/**")
                .uri("lb://inventoryservice"))
            .route("productservice", r -> r.path("/products/**")
                .uri("lb://productservice"))
            .build();
    }
}

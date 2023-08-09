package com.example.gatewayserver;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/api-server/**")
                        .filters(f -> f.rewritePath("/api-server/(?<segment>.*)", "/api/${segment}"))
                        .uri("http://localhost:8001/"))
                // Add more routes as needed
                .build();
    }
}

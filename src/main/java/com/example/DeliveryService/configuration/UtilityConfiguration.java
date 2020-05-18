package com.example.DeliveryService.configuration;

import com.example.DeliveryService.utility.OrderQueueSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilityConfiguration {
    @Bean
    public OrderQueueSingleton getOrderQueueSingleton() {
        return new OrderQueueSingleton();
    }
}

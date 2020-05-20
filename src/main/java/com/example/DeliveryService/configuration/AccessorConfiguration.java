package com.example.DeliveryService.configuration;

import com.example.DeliveryService.accessor.RestaurantServiceAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessorConfiguration {

    @Bean
    public RestaurantServiceAccessor getRestaurantServiceAccessor() {
        return new RestaurantServiceAccessor();
    }
}

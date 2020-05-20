package com.example.DeliveryService.configuration;

import com.example.DeliveryService.utility.OrderQueueSingleton;
import com.example.DeliveryService.utility.Scheduler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UtilityConfiguration {

    @Autowired
    private final DaoConfiguration daoConfiguration;

    @Autowired
    private final AccessorConfiguration accessorConfiguration;

    @Bean
    public OrderQueueSingleton getOrderQueueSingleton() {
        return new OrderQueueSingleton();
    }

    @Bean
    public Scheduler getScheduler() {
        return new Scheduler(getOrderQueueSingleton(), daoConfiguration.getDeliveryAgentDao(),
                accessorConfiguration.getRestaurantServiceAccessor());
    }
}

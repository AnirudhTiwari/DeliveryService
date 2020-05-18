package com.example.DeliveryService.configuration;

import com.example.DeliveryService.activity.AssignOrderActivity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ActivityConfiguration {
    @Autowired
    private final ComponentConfiguration componentConfiguration;

    @Bean
    public AssignOrderActivity getAssignOrderActivity() {
        return new AssignOrderActivity(componentConfiguration.getAssignOrderComponent());
    }
}

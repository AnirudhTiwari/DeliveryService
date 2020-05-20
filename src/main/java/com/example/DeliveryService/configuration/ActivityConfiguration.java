package com.example.DeliveryService.configuration;

import com.example.DeliveryService.activity.AssignOrderActivity;
import com.example.DeliveryService.activity.GetDeliveryAgentStatusActivity;
import com.example.DeliveryService.activity.UpdateDeliveryAgentStatusActivity;
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

    @Bean
    public UpdateDeliveryAgentStatusActivity getUpdateDeliveryAgentStatusActivity() {
        return new UpdateDeliveryAgentStatusActivity(componentConfiguration.getUpdateDeliveryAgentStatusComponent());
    }

    @Bean
    public GetDeliveryAgentStatusActivity getGetDeliveryAgentStatusActivity() {
        return new GetDeliveryAgentStatusActivity(componentConfiguration.getDeliveryAgentStatusComponent());
    }
}

package com.example.DeliveryService.configuration;

import com.example.DeliveryService.component.AssignOrderComponent;
import com.example.DeliveryService.component.GetDeliveryAgentStatusComponent;
import com.example.DeliveryService.component.UpdateDeliveryAgentStatusComponent;
import com.example.DeliveryService.utility.OrderQueueSingleton;
import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ComponentConfiguration {

    @Autowired
    private final UtilityConfiguration utilityConfiguration;

    @Autowired
    private final DaoConfiguration daoConfiguration;


    @Bean
    public AssignOrderComponent getAssignOrderComponent() {
        return new AssignOrderComponent(utilityConfiguration.getOrderQueueSingleton());
    }

    @Bean
    public UpdateDeliveryAgentStatusComponent getUpdateDeliveryAgentStatusComponent() {
        return new UpdateDeliveryAgentStatusComponent(daoConfiguration.getDeliveryAgentDao());
    }

    @Bean
    public GetDeliveryAgentStatusComponent getDeliveryAgentStatusComponent() {
        return new GetDeliveryAgentStatusComponent(daoConfiguration.getDeliveryAgentDao());
    }

}

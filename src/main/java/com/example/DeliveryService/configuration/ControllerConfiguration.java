package com.example.DeliveryService.configuration;

import com.example.DeliveryService.controller.AssignOrderController;
import com.example.DeliveryService.controller.GetDeliveryAgentStatusController;
import com.example.DeliveryService.controller.UpdateDeliveryAgentStatusController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ControllerConfiguration {
    @Autowired
    private final ActivityConfiguration activityConfiguration;

    public AssignOrderController getAssignOrderController() {
        return new AssignOrderController(activityConfiguration.getAssignOrderActivity());
    }

    public UpdateDeliveryAgentStatusController getUpdateDeliveryAgentStatusController() {
        return new UpdateDeliveryAgentStatusController(activityConfiguration.getUpdateDeliveryAgentStatusActivity());
    }

    public GetDeliveryAgentStatusController getGetDeliveryAgentStatusController() {
        return new GetDeliveryAgentStatusController(activityConfiguration.getGetDeliveryAgentStatusActivity());
    }
}

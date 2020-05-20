package com.example.DeliveryService.activity;

import com.example.DeliveryService.component.UpdateDeliveryAgentStatusComponent;
import com.example.DeliveryService.model.UpdateDeliveryAgentStatusRequest;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class UpdateDeliveryAgentStatusActivity {

    @NonNull
    private final UpdateDeliveryAgentStatusComponent updateDeliveryAgentStatusComponent;

    public void updateDeliveryAgentStatus(@NonNull final UpdateDeliveryAgentStatusRequest updateDeliveryAgentStatusRequest) {
        final Long deliveryAgentId = updateDeliveryAgentStatusRequest.getDeliveryAgentId();
        final String deliveryAgentStatus = updateDeliveryAgentStatusRequest.getDeliveryAgentStatus();
        updateDeliveryAgentStatusComponent.updateDeliveryAgentStatus(deliveryAgentId, deliveryAgentStatus);
    }
}

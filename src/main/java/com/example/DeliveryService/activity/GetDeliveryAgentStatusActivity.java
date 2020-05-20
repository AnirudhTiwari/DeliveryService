package com.example.DeliveryService.activity;

import com.example.DeliveryService.component.GetDeliveryAgentStatusComponent;
import com.example.DeliveryService.model.GetDeliveryAgentStatusRequest;
import com.example.DeliveryService.model.GetDeliveryAgentStatusResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class GetDeliveryAgentStatusActivity {

    @Autowired
    private final GetDeliveryAgentStatusComponent getDeliveryAgentStatusComponent;

    public GetDeliveryAgentStatusResponse getDeliveryAgentStatus(@NonNull final GetDeliveryAgentStatusRequest deliveryAgentStatusRequest) {
        return getDeliveryAgentStatusComponent.getDeliveryAgentStatus(deliveryAgentStatusRequest.getDeliveryAgentId());
    }
}

package com.example.DeliveryService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Builder
@Data
public class UpdateDeliveryAgentStatusRequest {
    @NonNull
    private final Long deliveryAgentId;

    @NonNull
    private final String deliveryAgentStatus;

}

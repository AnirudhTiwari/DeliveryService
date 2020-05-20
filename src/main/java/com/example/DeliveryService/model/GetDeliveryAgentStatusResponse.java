package com.example.DeliveryService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetDeliveryAgentStatusResponse {
    @NonNull
    private final Long deliveryAgentId;

    @NonNull
    private final String deliveryAgentStatus;

    @NonNull
    private final String deliveryAgentName;

    private final Long orderId;
    private final Long ETA;
}

package com.example.DeliveryService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class UpdateOrderRequest {
    @NonNull
    private final Long orderId;

    @NonNull
    private final Long deliveryAgentId;

    @NonNull
    private final String deliveryAgentName;

    @NonNull
    private final String orderStatus;

}

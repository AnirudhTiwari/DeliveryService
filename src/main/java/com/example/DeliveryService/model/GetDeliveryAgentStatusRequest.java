package com.example.DeliveryService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetDeliveryAgentStatusRequest {
    @NonNull
    private final Long deliveryAgentId;
}

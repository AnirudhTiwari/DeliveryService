package com.example.DeliveryService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AssignOrderRequest {
    @NonNull
    private final Long orderId;

    @NonNull
    private final String address;
}

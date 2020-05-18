package com.example.DeliveryService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
@Builder
public class AssignOrderResponse {
    @NonNull
    private final String response;
}

package com.example.DeliveryService.controller;

import com.example.DeliveryService.activity.AssignOrderActivity;
import com.example.DeliveryService.model.AssignOrderResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssignOrderController {
    @NonNull
    private final AssignOrderActivity assignOrderActivity;

    @PostMapping("/assignOrder")
    public AssignOrderResponse assignOrder(@RequestParam(value = "orderId") Long orderId) {
        assignOrderActivity.assignOrder(orderId);

        return AssignOrderResponse.builder().status("ACCEPTED").build();
    }
}

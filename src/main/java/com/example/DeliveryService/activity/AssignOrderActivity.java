package com.example.DeliveryService.activity;

import com.example.DeliveryService.component.AssignOrderComponent;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class AssignOrderActivity {
    @Autowired
    private final AssignOrderComponent assignOrderComponent;

    public void assignOrder(@NonNull final Long orderId) {
        assignOrderComponent.pushOrderToQueue(orderId);
    }
}

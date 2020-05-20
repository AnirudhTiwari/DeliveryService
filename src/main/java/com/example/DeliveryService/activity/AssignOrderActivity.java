package com.example.DeliveryService.activity;

import com.example.DeliveryService.component.AssignOrderComponent;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Log4j2
public class AssignOrderActivity {
    @Autowired
    private final AssignOrderComponent assignOrderComponent;

    public void assignOrder(@NonNull final Long orderId) {
        assignOrderComponent.pushOrderToQueue(orderId);
    }
}

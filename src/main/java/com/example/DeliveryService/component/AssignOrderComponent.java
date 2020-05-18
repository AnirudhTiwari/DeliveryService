package com.example.DeliveryService.component;

import com.example.DeliveryService.utility.OrderQueueSingleton;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;

@AllArgsConstructor
public class AssignOrderComponent {
    @Autowired
    OrderQueueSingleton orderQueueSingleton;

    public void pushOrderToQueue(@NonNull final Long orderId) {
        final LinkedList<Long> queue = orderQueueSingleton.getQueue();
        queue.add(orderId);
    }
}

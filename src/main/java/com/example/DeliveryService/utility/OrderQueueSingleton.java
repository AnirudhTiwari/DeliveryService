package com.example.DeliveryService.utility;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@AllArgsConstructor
@Data
public class OrderQueueSingleton {
    private final LinkedList<Long> queue = new LinkedList<>();
}

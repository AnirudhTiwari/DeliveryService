package com.example.DeliveryService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@Builder
public class DeliveryAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    private Long orderId;

    @NonNull
    @Enumerated(EnumType.STRING)
    private DeliveryAgentStatus status;

    private Long orderAssignmentTime;

    protected DeliveryAgent() { }

}

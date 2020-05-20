package com.example.DeliveryService.dao;

import com.example.DeliveryService.model.DeliveryAgent;
import com.example.DeliveryService.model.DeliveryAgentStatus;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeliveryAgentDao {

    @Autowired
    DeliveryAgentRepository deliveryAgentRepository;

    public List<DeliveryAgent> getInactiveDeliveryAgents() {
        List<DeliveryAgent> deliveryAgentList = new ArrayList<>();

        for (DeliveryAgent deliveryAgent : deliveryAgentRepository.findAll()) {
            if (deliveryAgent.getStatus().equals(DeliveryAgentStatus.INACTIVE)) {
                deliveryAgentList.add(deliveryAgent);
            }
        }
        return deliveryAgentList;
    }

    public void updateDeliveryAgent(@NonNull final DeliveryAgent deliveryAgent) {
        deliveryAgentRepository.save(deliveryAgent);
    }

    public Optional<DeliveryAgent> getDeliveryAgent(@NonNull final Long id) {
        return deliveryAgentRepository.findById(id);
    }
}

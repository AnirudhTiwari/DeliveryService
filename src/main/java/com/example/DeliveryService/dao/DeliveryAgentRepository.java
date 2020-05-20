package com.example.DeliveryService.dao;

import com.example.DeliveryService.model.DeliveryAgent;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeliveryAgentRepository extends CrudRepository<DeliveryAgent, Long> {
    Optional<DeliveryAgent> findById(Long deliveryAgentId);
}

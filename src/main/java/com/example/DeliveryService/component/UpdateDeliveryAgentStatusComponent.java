package com.example.DeliveryService.component;

import com.example.DeliveryService.dao.DeliveryAgentDao;
import com.example.DeliveryService.model.DeliveryAgent;
import com.example.DeliveryService.model.DeliveryAgentStatus;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@AllArgsConstructor
public class UpdateDeliveryAgentStatusComponent {
    @Autowired
    private final DeliveryAgentDao deliveryAgentDao;

    public void updateDeliveryAgentStatus(@NonNull final Long deliveryAgentId,
                                          @NonNull final String deliveryAgentStatus) {
        final Optional<DeliveryAgent>  deliveryAgentOptional = deliveryAgentDao.getDeliveryAgent(deliveryAgentId);
        if (deliveryAgentOptional.isPresent()) {
            final DeliveryAgent deliveryAgent = deliveryAgentOptional.get();
            deliveryAgent.setStatus(DeliveryAgentStatus.valueOf(deliveryAgentStatus));
            if ((deliveryAgent.getStatus().equals(DeliveryAgentStatus.INACTIVE))) {
                deliveryAgent.setOrderAssignmentTime(null);
                deliveryAgent.setOrderId(null);
            }
            deliveryAgentDao.updateDeliveryAgent(deliveryAgent);

        } else {
            final String errorMsg = String.format("Invalid delivery agent Id: %s", deliveryAgentId);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}

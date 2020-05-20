package com.example.DeliveryService.component;

import com.example.DeliveryService.dao.DeliveryAgentDao;
import com.example.DeliveryService.model.DeliveryAgent;
import com.example.DeliveryService.model.DeliveryAgentStatus;
import com.example.DeliveryService.model.GetDeliveryAgentStatusResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
public class GetDeliveryAgentStatusComponent {

    @Autowired
    private final DeliveryAgentDao deliveryAgentDao;

    //Hard coding ETA as 30 minutes once an order is picked up
    private static  final long ETA_POST_ORDER_PICK_UP = 1800000;


    public GetDeliveryAgentStatusResponse getDeliveryAgentStatus(@NonNull final Long deliveryAgentId) {
        final Optional<DeliveryAgent> deliveryAgentOptional = deliveryAgentDao.getDeliveryAgent(deliveryAgentId);


        if (deliveryAgentOptional.isPresent()) {
            final DeliveryAgent deliveryAgent = deliveryAgentOptional.get();
            final GetDeliveryAgentStatusResponse.GetDeliveryAgentStatusResponseBuilder
                    getDeliveryAgentStatusResponseBuilder = GetDeliveryAgentStatusResponse.builder()
                    .deliveryAgentId(deliveryAgentId)
                    .deliveryAgentName(deliveryAgent.getName());

            if (deliveryAgent.getStatus().equals(DeliveryAgentStatus.INACTIVE)) {
                return getDeliveryAgentStatusResponseBuilder
                        .deliveryAgentStatus(DeliveryAgentStatus.INACTIVE.name())
                        .build();
            } else {
                final Long orderETA = getOrderETA(deliveryAgent);
                return getDeliveryAgentStatusResponseBuilder
                        .deliveryAgentStatus(DeliveryAgentStatus.ACTIVE.name())
                        .ETA(orderETA)
                        .orderId(deliveryAgent.getOrderId())
                        .build();
            }
        } else {
            final String errorMsg = String.format("Invalid delivery agent Id: %s", deliveryAgentId);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private Long getOrderETA(final DeliveryAgent deliveryAgent) {
        final long currentTime = new Date().getTime();

        final long orderAssignmentTime = deliveryAgent.getOrderAssignmentTime();

        if (currentTime - orderAssignmentTime < ETA_POST_ORDER_PICK_UP) {
            return (ETA_POST_ORDER_PICK_UP - (currentTime - orderAssignmentTime)) / 60000;
        }

        return null;

    }
}

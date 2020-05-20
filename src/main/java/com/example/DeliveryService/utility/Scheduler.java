package com.example.DeliveryService.utility;

import com.example.DeliveryService.accessor.RestaurantServiceAccessor;
import com.example.DeliveryService.dao.DeliveryAgentDao;
import com.example.DeliveryService.model.DeliveryAgent;
import com.example.DeliveryService.model.DeliveryAgentStatus;
import com.example.DeliveryService.model.UpdateOrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class Scheduler {
    @Autowired
    private final OrderQueueSingleton orderQueueSingleton;

    @Autowired
    private final DeliveryAgentDao deliveryAgentDao;

    @Autowired
    private final RestaurantServiceAccessor restaurantServiceAccessor;

    /**
     * This is a poller which polls the queue every 5 seconds for new orders and assign the order to delivery executive
     * which are non-active. Post that, it makes a REST API call to Restaurant service to update the orderStatus with the
     * Delivery person details and the time of order assignment.
     */
    @Scheduled(fixedRate = 5000)
    public void AssignOrderToDeliveryExecutives() throws URISyntaxException {
        final LinkedList<Long> orderQueue = orderQueueSingleton.getQueue();
        if (orderQueue.isEmpty()) {
            System.out.println("Poller is active, awaiting orders");
        } else {
            List<DeliveryAgent> availableDeliveryAgents = deliveryAgentDao.getInactiveDeliveryAgents();
            if (availableDeliveryAgents.isEmpty()) {
                System.out.println(String.format("All delivery agents are occupied, %d orders in queue",
                        orderQueue.size()));
            } else {
                //Assign the first order in the queue to the delivery agent, update DeliveryAgent database and send
                // an update to the restaurant updateOrder API with the details.
                final Long firstOrder = orderQueue.poll();
                final DeliveryAgent deliveryAgent = availableDeliveryAgents.get(0);

                assignOrderToDeliveryAgent(firstOrder, deliveryAgent);
                final String msg = String.format("Assigned order %d to deliveryAgent %s", firstOrder,
                        deliveryAgent.getName());
                System.out.println(msg);

                //TODO: Make a call to Restaurant service to update the order status.
                updateOrder(firstOrder, deliveryAgent);

            }
        }

    }

    private void updateOrder(Long firstOrder, DeliveryAgent deliveryAgent) throws URISyntaxException {
        UpdateOrderRequest updateOrderRequest = UpdateOrderRequest.builder()
                .deliveryAgentId(deliveryAgent.getId())
                .deliveryAgentName(deliveryAgent.getName())
                .orderId(firstOrder)
                .orderStatus("IN_TRANSIT")
                .build();
        restaurantServiceAccessor.updateOrder(updateOrderRequest);
    }

    private void assignOrderToDeliveryAgent(final Long orderId, final DeliveryAgent deliveryAgent) {
        final long orderAssignmentTime = new Date().getTime();
        final DeliveryAgent updatedDeliveryAgent = DeliveryAgent.builder()
                .id(deliveryAgent.getId())
                .name(deliveryAgent.getName())
                .orderId(orderId)
                .status(DeliveryAgentStatus.ACTIVE)
                .orderAssignmentTime(orderAssignmentTime)
                .build();
        deliveryAgentDao.updateDeliveryAgent(updatedDeliveryAgent);
    }
}

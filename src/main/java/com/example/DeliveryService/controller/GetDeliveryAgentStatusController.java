package com.example.DeliveryService.controller;

import com.example.DeliveryService.activity.GetDeliveryAgentStatusActivity;
import com.example.DeliveryService.model.GetDeliveryAgentStatusRequest;
import com.example.DeliveryService.model.GetDeliveryAgentStatusResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetDeliveryAgentStatusController {
    @NonNull
    private final GetDeliveryAgentStatusActivity getDeliveryAgentStatusActivity;

    @GetMapping("/getDeliveryAgentStatus")
    public GetDeliveryAgentStatusResponse getDeliveryAgentStatus(@RequestParam(value = "deliveryAgentId") Long deliveryAgentId) {
        final GetDeliveryAgentStatusRequest getDeliveryAgentStatusRequest =
                GetDeliveryAgentStatusRequest.builder().deliveryAgentId(deliveryAgentId).build();
        return getDeliveryAgentStatusActivity.getDeliveryAgentStatus(getDeliveryAgentStatusRequest);
    }
}

package com.example.DeliveryService.controller;

import com.example.DeliveryService.activity.UpdateDeliveryAgentStatusActivity;
import com.example.DeliveryService.model.UpdateDeliveryAgentStatusRequest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UpdateDeliveryAgentStatusController {
    @NonNull
    private final UpdateDeliveryAgentStatusActivity updateDeliveryAgentStatusActivity;

    @PutMapping("/updateDeliveryAgentStatus")
    public void updateDeliveryAgentStatus(@RequestBody UpdateDeliveryAgentStatusRequest updateDeliveryAgentStatusRequest) {
        updateDeliveryAgentStatusActivity.updateDeliveryAgentStatus(updateDeliveryAgentStatusRequest);
    }
}

package com.example.DeliveryService.accessor;

import com.example.DeliveryService.model.UpdateOrderRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class RestaurantServiceAccessor {
    private static final String UPDATE_ORDER_URI = "http://localhost:8080/updateOrder";


    public void updateOrder(@NonNull final UpdateOrderRequest updateOrderRequest) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(UPDATE_ORDER_URI);

        restTemplate.put(uri, updateOrderRequest);

    }

}

package com.example.orderservice.controller;

import com.example.orderservice.model.Address;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderController implements OrderOperations{

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<Long> persistOrder(long paymentId, String userId, Address address) {
        if(userId.trim().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        try {
            Long orderId = this.orderService.saveOrder(userId, paymentId);
            return new ResponseEntity<>(orderId, HttpStatus.OK);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}

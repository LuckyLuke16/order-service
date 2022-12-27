package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderController implements OrderOperations{

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Long persistOrder(long paymentId, String userId) {
        if(userId.trim().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        try {
            return this.orderService.saveOrder(userId, paymentId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}

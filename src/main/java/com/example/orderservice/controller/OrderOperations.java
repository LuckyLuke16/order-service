package com.example.orderservice.controller;


import com.example.orderservice.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/orders")
public interface OrderOperations {

    @PostMapping
    ResponseEntity<Long> persistOrder(@RequestParam long paymentId, @RequestParam String userId, @RequestBody Address address);
}

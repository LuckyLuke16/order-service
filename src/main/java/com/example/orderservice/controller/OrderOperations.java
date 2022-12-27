package com.example.orderservice.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/orders")
public interface OrderOperations {

    @PostMapping
    Long persistOrder(@RequestParam long paymentId, @RequestParam String userId);
}

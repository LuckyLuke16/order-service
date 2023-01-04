package com.example.orderservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long orderId;

    private long paymentId;

    private String userId;

    public Order(long paymentId, String userId) {
        this.paymentId = paymentId;
        this.userId = userId;
    }
}

package com.microservices.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private double price;
    private String currency = "TND";
    private String method;
    private String intent = "Reservation";
    private String description = "Payment";
}

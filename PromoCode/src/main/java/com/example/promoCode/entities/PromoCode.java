package com.example.promoCode.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromoCode implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCode;
    private String code;
    private String description;
    private boolean isActive;
    private double discount;
    private int usageCount;
    private LocalDate startDate;
    private LocalDate endDate;
 }

package com.example.ms_reservationetbillets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Billet implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBillet;
    private Double price; // Prix du billet
    private LocalDate eventDate; // Date de l'événement du billet
    private Boolean isAvailable; // Indique si le billet est disponible
    private Integer quantiteDisponible; // La quantité de billets disponibles
}

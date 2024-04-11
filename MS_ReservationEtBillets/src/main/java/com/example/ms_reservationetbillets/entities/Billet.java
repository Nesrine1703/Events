package com.example.ms_reservationetbillets.entities;

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
public class Billet implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBillet;
    private Double price; // Prix du billet
    private LocalDate eventDate; // Date de l'événement du billet
    private Boolean isAvailable; // Indique si le billet est disponible
    private Integer quantiteDisponible; // La quantité de billets disponibles
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation; // La réservation à laquelle ce billet est associé

}

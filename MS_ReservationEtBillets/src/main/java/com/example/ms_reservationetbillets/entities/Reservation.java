package com.example.ms_reservationetbillets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idReservation;
    private LocalDate reservationDate; // Date de la réservation
    private Integer numberOfTickets; // Nombre de billets réservés
    private Boolean isPaid; // Indique si la réservation est payée
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Billet> billets; // Liste des billets réservés pour cette réservation
}

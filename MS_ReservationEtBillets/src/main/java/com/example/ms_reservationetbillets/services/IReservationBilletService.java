package com.example.ms_reservationetbillets.services;

import com.example.ms_reservationetbillets.entities.Reservation;

import java.util.List;

public interface IReservationBilletService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation (Reservation reservation);
    Reservation updateReservation (Reservation reservation);
    Reservation retrieveReservation(Integer idReservation);
    void removeReservation(Integer idReservation);

}

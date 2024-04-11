package com.example.ms_reservationetbillets.services;

import com.example.ms_reservationetbillets.entities.Billet;
import com.example.ms_reservationetbillets.entities.Reservation;

import java.util.List;

public interface IReservationBilletService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation (Reservation reservation);
    Reservation updateReservation (Reservation reservation);
    Reservation retrieveReservation(Integer idReservation);
    void removeReservation(Integer idReservation);


    List<Billet> retrieveAllBillets();
    Billet addBillet (Billet billet);
    Billet updateBillet (Billet billet);
    Billet retrieveBillet(Integer idBillet);
    void removeBillet(Integer idBillet);
}

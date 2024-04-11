package com.example.ms_reservationetbillets.services;

import com.example.ms_reservationetbillets.entities.Billet;
import com.example.ms_reservationetbillets.entities.Reservation;
import com.example.ms_reservationetbillets.repositories.BilletRepository;
import com.example.ms_reservationetbillets.repositories.ReservationRepesitory;
import com.example.ms_reservationetbillets.services.IReservationBilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationBilletService implements IReservationBilletService {
    @Autowired
    ReservationRepesitory reservationRepesitory;
    @Autowired
    BilletRepository billetRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepesitory.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepesitory.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepesitory.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(Integer idReservation) {
        return reservationRepesitory.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Integer idReservation) {
        reservationRepesitory.deleteById(idReservation);
    }

    @Override
    public List<Billet> retrieveAllBillets() {
        return billetRepository.findAll();
    }

    @Override
    public Billet addBillet(Billet billet) {
        return billetRepository.save(billet);
    }

    @Override
    public Billet updateBillet(Billet billet) {
        return billetRepository.save(billet);
    }

    @Override
    public Billet retrieveBillet(Integer idBillet) {
        return billetRepository.findById(idBillet).orElse(null);
    }

    @Override
    public void removeBillet(Integer idBillet) {
        billetRepository.deleteById(idBillet);
    }
}

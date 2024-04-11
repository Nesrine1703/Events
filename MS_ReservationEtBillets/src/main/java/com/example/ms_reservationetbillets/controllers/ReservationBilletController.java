package com.example.ms_reservationetbillets.controllers;

import com.example.ms_reservationetbillets.services.IReservationBilletService;
import com.example.ms_reservationetbillets.entities.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ReservationBillet")
public class ReservationBilletController {
    @Autowired
    private final IReservationBilletService iReservationBilletService;

    @GetMapping("/get-all-reservations")
    List<Reservation> getAllReservations() {
        return iReservationBilletService.retrieveAllReservations();
    }
    @GetMapping("/get-reservation/{idReservation}")
    Reservation getReservation(@PathVariable("idReservation") Integer idReservation) {
        return iReservationBilletService.retrieveReservation(idReservation);
    }
    @PostMapping("/add-reservation")
    Reservation addReservation(@RequestBody Reservation reservation) {
        return iReservationBilletService.addReservation(reservation);
    }
    @PutMapping("/update-reservation")
    Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservationBilletService.updateReservation(reservation);
    }
    @DeleteMapping("/delete-reservation/{idReservation}")
    void deleteReservation(@PathVariable("idReservation") Integer idReservation) {
        iReservationBilletService.removeReservation(idReservation);
    }
}

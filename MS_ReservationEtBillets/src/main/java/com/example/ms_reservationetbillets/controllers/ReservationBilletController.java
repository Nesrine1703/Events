package com.example.ms_reservationetbillets.controllers;

import com.example.ms_reservationetbillets.entities.Billet;
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

    @GetMapping("/get-all-billets")
    List<Billet> getAllBillets() {
        return iReservationBilletService.retrieveAllBillets();
    }
    @GetMapping("/get-billet/{idBillet}")
    Billet getBillet(@PathVariable("idBillet") Integer idBillet) {
        return iReservationBilletService.retrieveBillet(idBillet);
    }
    @PostMapping("/add-billet")
    Billet addBillet(@RequestBody Billet billet) {
        return iReservationBilletService.addBillet(billet);
    }
    @PutMapping("/update-billet")
    Billet updateBillet(@RequestBody Billet billet) {
        return iReservationBilletService.updateBillet(billet);
    }
    @DeleteMapping("/delete-billet/{idBillet}")
    void deleteBillet(@PathVariable("idBillet") Integer idBillet) {
        iReservationBilletService.removeBillet(idBillet);
    }
}

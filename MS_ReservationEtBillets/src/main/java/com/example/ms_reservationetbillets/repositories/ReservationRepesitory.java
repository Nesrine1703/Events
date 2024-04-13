package com.example.ms_reservationetbillets.repositories;

import com.example.ms_reservationetbillets.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepesitory extends JpaRepository<Reservation, Integer> {
}

package com.example.ms_reservationetbillets.repositories;

import com.example.ms_reservationetbillets.entities.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Integer> {
}

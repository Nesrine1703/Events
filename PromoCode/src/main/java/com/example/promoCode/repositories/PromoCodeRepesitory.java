package com.example.promoCode.repositories;

import com.example.promoCode.entities.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepesitory extends JpaRepository<PromoCode, Integer> {
}

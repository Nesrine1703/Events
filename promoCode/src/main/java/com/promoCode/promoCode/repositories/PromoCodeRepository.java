package com.promoCode.promoCode.repositories;


import com.promoCode.promoCode.entities.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodeRepository extends JpaRepository<PromoCode, String> {
}

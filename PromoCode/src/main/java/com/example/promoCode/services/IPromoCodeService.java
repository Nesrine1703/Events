package com.example.promoCode.services;

import com.example.promoCode.entities.PromoCode;

import java.util.List;

public interface IPromoCodeService {

        List<PromoCode> getAllPromoCodes();
        PromoCode addPromoCode(PromoCode promoCode);
        PromoCode updatePromoCode(PromoCode promoCode);
        PromoCode getPromoCode(Integer id);
        void deletePromoCode(Integer id);


}

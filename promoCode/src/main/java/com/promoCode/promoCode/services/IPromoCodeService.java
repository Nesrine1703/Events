package com.promoCode.promoCode.services;


import com.promoCode.promoCode.entities.PromoCode;

public interface IPromoCodeService {

    PromoCode createPromoCode(PromoCode promoCode);

    PromoCode updatePromoCode(PromoCode promoCode);

    void deletePromoCode(String code);

    PromoCode usePromoCode(String code);
}

package com.example.promoCode.services;

import com.example.promoCode.entities.PromoCode;
import com.example.promoCode.repositories.PromoCodeRepesitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoCodeService implements IPromoCodeService {
    @Autowired
    PromoCodeRepesitory promoCodeRepesitory;

    @Override
    public List<PromoCode> getAllPromoCodes() {
        return promoCodeRepesitory.findAll();
    }

    @Override
    public PromoCode addPromoCode(PromoCode promoCode) {
        return promoCodeRepesitory.save(promoCode);
    }

    @Override
    public PromoCode updatePromoCode(PromoCode promoCode) {
        return promoCodeRepesitory.save(promoCode);
    }

    @Override
    public PromoCode getPromoCode(Integer id) {
        return promoCodeRepesitory.findById(id).orElse(null);
    }

    @Override
    public void deletePromoCode(Integer id) {
        promoCodeRepesitory.deleteById(id);
    }

}

package com.promoCode.promoCode.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promoCode.promoCode.entities.PromoCode;
import com.promoCode.promoCode.repositories.PromoCodeRepository;

@Service
public class PromoCodeService implements IPromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    @Autowired
    public PromoCodeService (PromoCodeRepository promoCodeRepository) {
        this.promoCodeRepository = promoCodeRepository;
    }

    @Override
    public PromoCode createPromoCode(PromoCode promoCode) {
        return promoCodeRepository.save(promoCode);
    }

    @Override
    public PromoCode updatePromoCode(PromoCode promoCode) {
        return promoCodeRepository.save(promoCode);
    }

    @Override
    public void deletePromoCode(String code) {
        promoCodeRepository.deleteById(code);
    }

    @Override
    public PromoCode usePromoCode(String code) {
        PromoCode promoCode = promoCodeRepository.findById(code).orElseThrow();
        promoCode.setUsageCount(promoCode.getUsageCount() + 1);
        return promoCodeRepository.save(promoCode);
    }
}

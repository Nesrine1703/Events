package com.example.promoCode.controllers;

import com.example.promoCode.services.IPromoCodeService;
import com.example.promoCode.entities.PromoCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/PromoCode")
public class PromoCodeController {
    @Autowired
    private final IPromoCodeService iPromoCodeService;

    @GetMapping("/get-all-promoCodes")
    List<PromoCode> getAllPromoCodes() {
        return iPromoCodeService.getAllPromoCodes();
    }

    @GetMapping("/get-promoCode/{id}")
    PromoCode getPromoCode(@PathVariable("id") Integer id) {
        return iPromoCodeService.getPromoCode(id);
    }

    @PostMapping("/add-promoCode")
    PromoCode addPromoCode(@RequestBody PromoCode promoCode) {
        return iPromoCodeService.addPromoCode(promoCode);
    }

    @PutMapping("/update-promoCode")
    PromoCode updatePromoCode(@RequestBody PromoCode promoCode) {
        return iPromoCodeService.updatePromoCode(promoCode);
    }

    @DeleteMapping("/delete-promoCode/{id}")
    void deletePromoCode(@PathVariable("id") Integer id) {
        iPromoCodeService.deletePromoCode(id);
    }
}

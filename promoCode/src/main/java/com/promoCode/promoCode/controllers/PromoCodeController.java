package com.promoCode.promoCode.controllers;

// PromoCodeController.java
import com.promoCode.promoCode.entities.PromoCode;
import com.promoCode.promoCode.services.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/promoCodes")
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @PostMapping
    public PromoCode createPromoCode(@RequestBody PromoCode promoCode) {
        return promoCodeService.createPromoCode(promoCode);
    }

    @PutMapping("/{code}")
    public PromoCode updatePromoCode(@PathVariable String code, @RequestBody PromoCode promoCode) {
        promoCode.setCode(code);
        return promoCodeService.updatePromoCode(promoCode);
    }

    @DeleteMapping("/{code}")
    public void deletePromoCode(@PathVariable String code) {
        promoCodeService.deletePromoCode(code);
    }

    @PostMapping("/{code}/use")
    public PromoCode usePromoCode(@PathVariable String code) {
        return promoCodeService.usePromoCode(code);
    }
}

package com.microservices.payment.controller;

import com.microservices.payment.entity.Payment;
import com.microservices.payment.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaypalController {

    @Autowired
    private PaypalService paypalService;

    public static final String successUrl = "http://localhost:8086/pay/success";
    public static final String cancelUrl = "http://localhost:8086/pay/cancel";

    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") Payment payment) throws PayPalRESTException {
        try {
            com.paypal.api.payments.Payment thePayment = paypalService.createPayment(payment.getPrice(), payment.getCurrency(),
                    payment.getMethod(), payment.getIntent(), payment.getDescription(), cancelUrl, successUrl);
            for (Links links : thePayment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    System.out.println(links.getHref());
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException payPalRESTException) {
            payPalRESTException.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            com.paypal.api.payments.Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

}

package com.m_code.Fawry.Services.controllers;

import com.m_code.Fawry.Payment.models.MobilePaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Payment.services.PaymentService;
import com.m_code.Fawry.Services.MobileServices.MobileRechargeForm;

@RestController
@RequestMapping("/api/mobile")
public class MobileServiceController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PaymentService payservice;

    @PostMapping("/{name:[a-zA-Z &+-]*}/pay/balance")
    public ResponseEntity<?> payBalance(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @PathVariable(name = "name") String name, @RequestBody MobileRechargeForm form) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        if (form.validate()) {
            return payservice.payBalance(username, name, form);
        }
        return ResponseEntity.badRequest().body("Invalid Form");
    }

    @PostMapping("/{name:[a-zA-Z &+-]*}/pay/creditcard")
    public ResponseEntity<?> payCreditCard(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @PathVariable(name = "name") String name, @RequestBody MobilePaymentDto paymentdto) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        if (paymentdto.form.validate()) {

            if (paymentdto.creditcard.validate()) {
                return payservice.payCreditCard(username, paymentdto.creditcard, name, paymentdto.form);
            }
            return ResponseEntity.badRequest().body("Invalid Credit Card");
        }
        return ResponseEntity.badRequest().body("Invalid Form");
    }

    @PostMapping("/{name:[a-zA-Z &+-]*}/pay/cod")
    public ResponseEntity<?> paycod(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @PathVariable(name = "name") String name, @RequestBody MobileRechargeForm form) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        if (form.validate()) {
            return payservice.paycod(username, name, form);
        }
        return ResponseEntity.badRequest().body("Invalid Form");
    }

    @GetMapping("/{name:[a-zA-Z &+-]*}/getbill")
    public ResponseEntity<?> getBill(@PathVariable(name = "name") String name, @RequestBody MobileRechargeForm form) {
        if (form.validate()) {
            return payservice.getBill(name, form);
        }
        return ResponseEntity.badRequest().body("Invalid Form");
    }
}

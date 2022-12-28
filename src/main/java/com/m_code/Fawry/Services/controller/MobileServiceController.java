package com.m_code.Fawry.Services.controller;

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
import com.m_code.Fawry.Payment.CreditCardDto;
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
        return payservice.payBalance(username, name, form);
    }

    @PostMapping("/{name:[a-zA-Z &+-]*}/pay/creditcard")
    public ResponseEntity<?> payCreditCard(
            @PathVariable(name = "name") String name, @RequestBody MobileRechargeForm form,
            @RequestBody CreditCardDto credit) {
        System.out.println(form.getMobilenumber());
        System.out.println(credit.getCardnumber());
        System.out.println(credit.getCardholdername());
        return payservice.payCreditCard(credit, name, form);
    }

    @GetMapping("/{name:[a-zA-Z &+-]*}/getbill")
    public ResponseEntity<?> getBill(@PathVariable(name = "name") String name, @RequestBody MobileRechargeForm form) {
        return payservice.getBill(name, form);
    }
}

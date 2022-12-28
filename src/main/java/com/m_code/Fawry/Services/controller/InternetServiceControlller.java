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
import com.m_code.Fawry.Payment.services.PaymentService;
import com.m_code.Fawry.Services.InternetServices.InternetPaymentForm;

@RestController
@RequestMapping("/api/internet")
public class InternetServiceControlller {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PaymentService payservice;

    @PostMapping("/{name:[a-zA-Z &+-]*}/pay/balance")
    public ResponseEntity<?> pay(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @PathVariable(name = "name") String name, @RequestBody InternetPaymentForm form) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        return payservice.payBalance(username, name, form);
    }

    @GetMapping("/{name:[a-zA-Z &+-]*}/getbill")
    public ResponseEntity<?> getBill(@PathVariable(name = "name") String name, @RequestBody InternetPaymentForm form) {
        return payservice.getBill(name, form);
    }
}

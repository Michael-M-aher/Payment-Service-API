package com.m_code.Fawry.Services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Payment.services.PaymentService;
import com.m_code.Fawry.Services.LandlineServices.LandlineForm;

@RestController
@RequestMapping("/api/Landline")
public class LandlineServiceController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PaymentService payservice;

    @PostMapping("/{name:[a-zA-Z &+-]*}/pay/balance")
    public ResponseEntity<?> pay(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @PathVariable(name = "name") String name, @RequestBody LandlineForm form) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        return payservice.pay(username, name, form);
    }

}

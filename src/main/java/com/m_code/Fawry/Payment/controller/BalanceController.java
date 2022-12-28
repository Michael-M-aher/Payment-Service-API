package com.m_code.Fawry.Payment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Payment.CreditCardDto;
import com.m_code.Fawry.Payment.services.BalanceService;
import com.m_code.Fawry.RuntimeData.DataStoreRuntime;

@RestController
@RequestMapping("/api")

public class BalanceController {

    @Autowired
    BalanceService Bs;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    DataStoreRuntime dts;

    @PostMapping(value = "/addBalance") // implement to add balance from visa
    public ResponseEntity<?> addBalance(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @RequestBody Map<String, Double> values, @RequestBody CreditCardDto creditcard) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        double balance = values.get("balance");
        if (balance < 0) {
            return ResponseEntity.ok("Invalid negative amount");
        }

        if (creditcard.decreaseBalance((float) balance)) {
            Bs.addBalance(username, balance);
            return ResponseEntity.ok("Amount added");

        } else {
            return ResponseEntity.ok("Insufficent funds in credit cartd");
        }
        // path card holder ccv , card number
    }

}

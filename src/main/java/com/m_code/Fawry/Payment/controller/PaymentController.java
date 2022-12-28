package com.m_code.Fawry.Payment.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Payment.services.BalanceService;
import com.m_code.Fawry.RuntimeData.DataStoreRuntime;
import com.m_code.Fawry.Services.AbstractService.AbstractService;

@RestController
@RequestMapping("/api")

public class PaymentController {

    @Autowired
    BalanceService Bs;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    DataStoreRuntime dts;

    @PostMapping(value = "/addBalance")
    public ResponseEntity<?> addBalance(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @RequestBody Map<String, Double> values) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        double balance = values.get("balance");
        if (balance < 0) {
            return ResponseEntity.ok("Invalid amount negative amount");
        }
        Bs.addBalance(username, balance);
        return ResponseEntity.ok("Amount added");
    }

    @PostMapping("/visa")
    public ResponseEntity<?> visa(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @RequestParam(name = "name") String name) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        ArrayList<AbstractService> services = dts.getServices();
        AbstractService service = null;
        for (AbstractService s : services) {
            if (s.getServiceProviderName().equals(name)) {
                service = s;
            }
        }
        if (service == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Service found with this name");
        } else {
            float bill = service.getBill();
            if (Bs.decreaseBalance(username, bill)) {
                return ResponseEntity.ok("Payment Successful" + bill);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not enough balance");
            }
        }

    }

}

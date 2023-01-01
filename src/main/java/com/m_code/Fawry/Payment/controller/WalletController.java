package com.m_code.Fawry.Payment.controller;

import com.m_code.Fawry.Transaction.models.Transaction;
import com.m_code.Fawry.Transaction.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Payment.models.WalletPaymentDto;
import com.m_code.Fawry.Payment.services.WalletService;
import com.m_code.Fawry.RuntimeData.DataStoreRuntime;

@RestController
@RequestMapping("/api")

public class WalletController {

    @Autowired
    WalletService Bs;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    DataStoreRuntime dts;

    @PostMapping(value = "/wallet/addmoney") // implement to add balance from visa
    public ResponseEntity<?> addMoney(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken,
            @RequestBody WalletPaymentDto walletPaymentDto) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);

        if (!walletPaymentDto.creditcard.validate()) {
            return ResponseEntity.badRequest().body("Invalid Credit Card");
        }

        if (walletPaymentDto.amount < 0) {
            return ResponseEntity.ok("Invalid negative amount");
        }

        if (walletPaymentDto.creditcard.decreaseBalance(walletPaymentDto.amount)) {
            Bs.addBalance(username, walletPaymentDto.amount);
            dts.addTransaction(new Transaction(dts.getTransactionId(), TransactionType.AddToWalletTransaction, username,
                    "Wallet", walletPaymentDto.amount));
            return ResponseEntity.ok("Amount added");

        } else {
            return ResponseEntity.ok("Insufficent funds in credit cart");
        }
    }

}

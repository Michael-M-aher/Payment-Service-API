package com.m_code.Fawry.Transaction.controller;

import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.RuntimeData.DataStoreRuntime;
import com.m_code.Fawry.Transaction.models.Transaction;
import com.m_code.Fawry.Transaction.models.TransactionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    DataStoreRuntime dts;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/getall")
    public ResponseEntity<?> getUserAll(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        ArrayList<Transaction> transactions = dts.getUserTransactions(username);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/refund/{id}")
    public ResponseEntity<?> refund(@PathVariable int id,
            @CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken) {
        String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
        ArrayList<Transaction> transactions = dts.getUserTransactions(username);
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                if (!dts.getRefundRequests().contains(transaction)) {
                    dts.addRefund(transaction);
                    return ResponseEntity.ok("Refund request sent successfully");
                }
                return ResponseEntity.ok("Refund request already sent");
            }
        }
        return ResponseEntity.badRequest().body("Transaction Not Found");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getall")
    public ResponseEntity<?> getAll() {
        ArrayList<Transaction> transactions = dts.getTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getpayment")
    public ResponseEntity<?> getPayment() {
        ArrayList<Transaction> transactions = dts.getTransactions();
        ArrayList<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals(TransactionType.PaymentTransaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return ResponseEntity.ok(filteredTransactions);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getwallet")
    public ResponseEntity<?> getWallet() {
        ArrayList<Transaction> transactions = dts.getTransactions();
        ArrayList<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals(TransactionType.AddToWalletTransaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return ResponseEntity.ok(filteredTransactions);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getrefund")
    public ResponseEntity<?> getRefund() {
        ArrayList<Transaction> transactions = dts.getTransactions();
        ArrayList<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals(TransactionType.RefundTransaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return ResponseEntity.ok(filteredTransactions);
    }

}

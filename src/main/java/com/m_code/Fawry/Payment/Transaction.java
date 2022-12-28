package com.m_code.Fawry.Payment;

import com.m_code.Fawry.Services.AbstractService.AbstractService;

public class Transaction {
    private String username;

    public String getUser() {
        return username;
    }

    private AbstractService service;
    private float amount;

    public Transaction(AbstractService service, float amount) {
        // this.user = User.getInstance();
        this.service = service;
        this.amount = amount;
    }

    public AbstractService getService() {
        return service;
    }

    public float getAmount() {
        return amount;
    }
}

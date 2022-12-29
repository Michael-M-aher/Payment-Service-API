package com.m_code.Fawry.Payment.models;

import com.m_code.Fawry.Services.AbstractService.AbstractService;

public class Transaction {
    private String username;
    private AbstractService service;
    private float amount;

    public Transaction(String username, AbstractService service, float amount) {
        this.username = username;
        this.service = service;
        this.amount = amount;
    }

    public String getUser() {
        return username;
    }

    public AbstractService getService() {
        return service;
    }

    public float getAmount() {
        return amount;
    }
}

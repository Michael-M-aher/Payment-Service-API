package com.m_code.Fawry.Transaction.models;

public class Transaction {

    int id;

    TransactionType transactionType;

    private String username;
    private String serviceProviderName;
    private float amount;

    public Transaction(int id, TransactionType transactionType, String username, String serviceProviderName,
            float amount) {
        this.id = id;
        this.transactionType = transactionType;
        this.username = username;
        this.serviceProviderName = serviceProviderName;
        this.amount = amount;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getUsername() {
        return username;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public float getAmount() {
        return amount;
    }
}

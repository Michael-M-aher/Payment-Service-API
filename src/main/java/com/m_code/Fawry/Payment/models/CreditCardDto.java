package com.m_code.Fawry.Payment.models;

public class CreditCardDto {
    String cardnumber;
    String cardholdername;
    String expirationdate;
    String cvv;

    private float getBalance() {
        // connect to bank api and get balance
        return (float) (Math.random() * 1000);
    }

    public Boolean decreaseBalance(float amount) {
        if (getBalance() >= amount) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean validate() {
        return (cardnumber != null && cardholdername != null && expirationdate != null && cvv != null);
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public String getCvv() {
        return cvv;
    }
}

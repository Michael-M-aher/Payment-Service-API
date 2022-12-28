package com.m_code.Fawry.Payment;

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

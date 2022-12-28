package com.m_code.Fawry.Payment;

import java.util.Scanner;

//Strategy Concrete Class
public class CreditCardPayment {
    String cardNumber;
    String cardHolderName;
    String expirationDate;
    String cvv;

    private void getCreditCardInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your card number: ");
        this.cardNumber = sc.nextLine();
        System.out.println("Enter your card holder name: ");
        this.cardHolderName = sc.nextLine();
        System.out.println("Enter your card expiration date: ");
        this.expirationDate = sc.nextLine();
        System.out.println("Enter your card cvv: ");
        this.cvv = sc.nextLine();
    }

    private float getBalance() {
        // connect to bank api and get balance
        return (float) (Math.random() * 1000);
    }

    private void DecreaseBalance(float amount) {
        // connect to bank api and decrease balance
        System.out.println("Decreased balance from Credit Card by " + amount);
    }

    public Boolean checkBalanceAndPay(float amount) {
        getCreditCardInfo();
        if (getBalance() >= amount) {
            DecreaseBalance(amount);
            return true;
        } else {
            return false;
        }
    }

}

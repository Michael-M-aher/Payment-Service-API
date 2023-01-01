package com.m_code.Fawry.Payment.models;

import com.m_code.Fawry.Services.InternetServices.InternetPaymentForm;

public class InternetPaymentDto {
    public InternetPaymentForm form;
    public CreditCardDto creditcard;

    public InternetPaymentDto(InternetPaymentForm form, CreditCardDto creditcard) {
        this.form = form;
        this.creditcard = creditcard;
    }

    public InternetPaymentDto(InternetPaymentForm form) {
        this.form = form;
    }
}

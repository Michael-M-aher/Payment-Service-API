package com.m_code.Fawry.Payment.models;

import com.m_code.Fawry.Services.DonationsServices.DonationsForm;

public class DonationsPaymentDto {
    public DonationsForm form;
    public CreditCardDto creditcard;

    public DonationsPaymentDto(DonationsForm form, CreditCardDto creditcard) {
        this.form = form;
        this.creditcard = creditcard;
    }

    public DonationsPaymentDto(DonationsForm form) {
        this.form = form;
    }
}

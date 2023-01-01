package com.m_code.Fawry.Payment.models;

import com.m_code.Fawry.Services.LandlineServices.LandlineForm;

public class LandlinePaymentDto {
    public LandlineForm form;
    public CreditCardDto creditcard;

    public LandlinePaymentDto(LandlineForm form, CreditCardDto creditcard) {
        this.form = form;
        this.creditcard = creditcard;
    }

    public LandlinePaymentDto(LandlineForm form) {
        this.form = form;
    }
}

package com.m_code.Fawry.Payment.models;

import com.m_code.Fawry.Services.MobileServices.MobileRechargeForm;

public class MobilePaymentDto {
    public MobileRechargeForm form;
    public CreditCardDto creditcard;

    public MobilePaymentDto(MobileRechargeForm form, CreditCardDto creditcard) {
        this.form = form;
        this.creditcard = creditcard;
    }

    public MobilePaymentDto(MobileRechargeForm form) {
        this.form = form;
    }
}

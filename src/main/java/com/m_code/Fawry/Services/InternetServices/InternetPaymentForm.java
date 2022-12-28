package com.m_code.Fawry.Services.InternetServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;

//Concrete Product A
public class InternetPaymentForm extends ServiceForm {

    private String landlinenumber;
    private float billamount;

    public String getLandlinenumber() {
        return landlinenumber;
    }

    public void setLandlinenumber(String landLineNumber) {
        landlinenumber = landLineNumber;
    }

    public float getBillamount() {
        return billamount;
    }

    public void setBillamount(float billAmount) {
        billamount = billAmount;
    }

}

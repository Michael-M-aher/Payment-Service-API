package com.m_code.Fawry.Services.MobileServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;

//Concrete Product A
public class MobileRechargeForm extends ServiceForm {
    private String mobilenumber;
    private String rechargeamount;

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobileNumber) {
        this.mobilenumber = mobileNumber;
    }

    public String getRechargeamount() {
        return rechargeamount;
    }

    public void setRechargeamount(String amount) {
        this.rechargeamount = amount;
    }

    @Override
    public Boolean validate() {
        return (mobilenumber != null && rechargeamount != null);
    }

}

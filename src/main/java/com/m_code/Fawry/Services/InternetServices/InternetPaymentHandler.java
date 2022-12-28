package com.m_code.Fawry.Services.InternetServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Concrete Product B
public class InternetPaymentHandler extends ServiceHandler {
    @Override
    public void pay(String serviceRequest, ServiceForm serviceForm) {
        System.out.println("You have paid the bill for " + serviceRequest);
        System.out
                .println("You have paid for the landline service: "
                        + ((InternetPaymentForm) serviceForm).getLandlinenumber());
    }

    @Override
    public float getBill(String serviceRequest, ServiceForm serviceForm) {
        System.out.println("You are getting bill amount from  " + serviceRequest);
        float billAmount = (float) (Math.random() * (1000 - 140) + 140);
        return billAmount;
    }
}

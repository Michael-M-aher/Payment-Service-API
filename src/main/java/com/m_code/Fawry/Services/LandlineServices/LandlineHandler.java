package com.m_code.Fawry.Services.LandlineServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Concrete Product B
public class LandlineHandler extends ServiceHandler {
    @Override
    public void pay(String serviceRequest, ServiceForm serviceForm) {
        System.out.println("You have paid the bill for " + serviceRequest);
        System.out
                .println("You have paid for the landline service: " + ((LandlineForm) serviceForm).getLandlinenumber());
    }

    public float getBill(String serviceRequest, ServiceForm serviceForm) {
        System.out.println("You are getting bill amount from  " + serviceRequest);
        float billAmount = (float) (Math.random() * (100 - 30) + 30);
        return billAmount;
    }
}

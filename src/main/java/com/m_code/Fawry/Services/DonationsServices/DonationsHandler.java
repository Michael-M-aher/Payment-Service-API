package com.m_code.Fawry.Services.DonationsServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Concrete Product B
public class DonationsHandler extends ServiceHandler {
    @Override
    public void pay(String serviceRequest, ServiceForm serviceForm) {
        System.out.println("You have paid the bill for " + serviceRequest);
        System.out
                .println("You have paid for the donation service: "
                        + ((DonationsForm) serviceForm).getDonationaccount());
    }

    public float getBill(String serviceRequest, ServiceForm serviceForm) {
        System.out.println("You are getting bill amount from  " + serviceRequest);
        float billAmount = Float.parseFloat(((DonationsForm) serviceForm).getDonationamount());
        return billAmount;
    }
}

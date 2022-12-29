package com.m_code.Fawry.Services.DonationsServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;

import lombok.NoArgsConstructor;

//Concrete Product A
@NoArgsConstructor
public class DonationsForm extends ServiceForm {
    String donationamount;

    public String getDonationamount() {
        return donationamount;
    }

    @Override
    public Boolean validate() {
        return (donationamount != null);
    }

}

package com.m_code.Fawry.Services.DonationsServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;

//Concrete Product A
public class DonationsForm extends ServiceForm {
    String donationaccount;
    String donationamount;

    public String getDonationamount() {
        return donationamount;
    }

    DonationsForm(String DonationAccount) {
        this.donationaccount = DonationAccount;
    }

    public String getDonationaccount() {
        return donationaccount;
    }

    @Override
    public Boolean validate() {
        return (donationaccount != null && donationamount != null);
    }

}

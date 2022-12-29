package com.m_code.Fawry.Services.DonationsServices;

//Concrete CLasss Service Provider
public class MagdyYaacoubHospital extends AbstractDonationsService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.Fawry.com/" + getDonationAccount() + "/pay", serviceForm);

    }

    @Override
    final String getDonationAccount() {
        return "13500";
    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.Fawry.com/" + getDonationAccount() + "/getbill",
                serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Magdy Yaacoub Hospital";
    }

    @Override
    protected Boolean allowCod() {
        return true;
    }

}

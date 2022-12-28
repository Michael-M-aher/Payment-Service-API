package com.m_code.Fawry.Services.InternetServices;

//Concrete CLasss Service Provider
public class VodafoneInternet extends AbstractInternetPaymentService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.vodafone.com/internet/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.vodafone.com/internet/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Vodafone Internet";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

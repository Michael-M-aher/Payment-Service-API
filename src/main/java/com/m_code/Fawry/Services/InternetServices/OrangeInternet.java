package com.m_code.Fawry.Services.InternetServices;

//Concrete CLasss Service Provider
public class OrangeInternet extends AbstractInternetPaymentService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.orange.com/internet/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.orange.com/internet/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Orange Internet";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

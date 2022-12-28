package com.m_code.Fawry.Services.InternetServices;

//Concrete CLasss Service Provider
public class WeInternet extends AbstractInternetPaymentService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.we.com/internet/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.we.com/internet/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "We Internet";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

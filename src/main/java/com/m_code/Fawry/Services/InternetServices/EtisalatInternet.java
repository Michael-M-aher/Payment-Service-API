package com.m_code.Fawry.Services.InternetServices;

//Concrete CLasss Service Provider
public class EtisalatInternet extends AbstractInternetPaymentService {

    @Override
    public void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.etisalat.com/internet/pay", serviceForm);

    }

    @Override
    public float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.etisalat.com/internet/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Etisalat Internet";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

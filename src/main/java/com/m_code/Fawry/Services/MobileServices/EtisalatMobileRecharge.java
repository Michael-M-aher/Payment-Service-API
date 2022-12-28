package com.m_code.Fawry.Services.MobileServices;

//Concrete CLasss Service Provider
public class EtisalatMobileRecharge extends AbstractMobileRechargeService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.etisalat.com/mobile/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.etisalat.com/mobile/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Etisalat Mobile";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

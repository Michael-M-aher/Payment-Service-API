package com.m_code.Fawry.Services.MobileServices;

//Concrete CLasss Service Provider
public class OrangeMobileRecharge extends AbstractMobileRechargeService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.orange.com/mobile/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.orange.com/mobile/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Orange Mobile";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

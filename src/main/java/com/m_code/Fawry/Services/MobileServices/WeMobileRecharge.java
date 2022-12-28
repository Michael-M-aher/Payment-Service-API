package com.m_code.Fawry.Services.MobileServices;

//Concrete CLasss Service Provider
public class WeMobileRecharge extends AbstractMobileRechargeService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.we.com/mobile/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.we.com/mobile/getbill", serviceForm);
        return billAmount;
    }

    @Override
    protected String creatserviceProviderName() {
        return "We Mobile";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

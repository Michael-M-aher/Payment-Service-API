package com.m_code.Fawry.Services.MobileServices;

//Concrete CLasss Service Provider
public class VodafoneMobileRecharge extends AbstractMobileRechargeService {

    @Override
    protected void serviceProviderPayLogic() {
        serviceHandler.pay("http://www.vodafone.com/mobile/pay", serviceForm);

    }

    @Override
    protected float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.vodafone.com/mobile/getbill", serviceForm);
        return billAmount;

    }

    @Override
    protected String creatserviceProviderName() {
        return "Vodafone Mobile";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

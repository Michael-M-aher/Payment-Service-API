package com.m_code.Fawry.Services.LandlineServices;

//Concrete CLasss Service Provider
public class LandlineMonthly extends AbstractLandlineService {

    @Override
    public void serviceProviderPayLogic() {

        serviceHandler.pay("http://www.we.com/landline/monthly/pay", serviceForm);
    }

    @Override
    public float serviceProviderGetBillLogic() {
        float billAmount = serviceHandler.getBill("http://www.we.com/landline/monthly/getbill", serviceForm);
        return billAmount;
    }

    @Override
    protected String creatserviceProviderName() {
        return "Landline Monthly";
    }

    @Override
    protected Boolean allowCod() {
        return false;
    }

}

package com.m_code.Fawry.Services.MobileServices;

import com.m_code.Fawry.Services.AbstractService.AbstractService;
import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Factory Creator Class Service
public abstract class AbstractMobileRechargeService extends AbstractService {

    @Override
    protected ServiceForm creatServiceForm() {
        return new MobileRechargeForm();
    }

    @Override
    protected ServiceHandler creatServiceHandler() {
        return new MobileRechargeHandler();
    }

    @Override
    protected String creatServiceName() {
        return "Mobile Recharge";
    }
}

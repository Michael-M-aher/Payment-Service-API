package com.m_code.Fawry.Services.LandlineServices;

import com.m_code.Fawry.Services.AbstractService.AbstractService;
import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Factory Creator Class Service
public abstract class AbstractLandlineService extends AbstractService {
    @Override
    protected ServiceForm creatServiceForm() {
        return new LandlineForm();
    }

    @Override
    protected ServiceHandler creatServiceHandler() {
        return new LandlineHandler();
    }

    @Override
    protected String creatServiceName() {
        return "Landline";
    }

    public abstract void serviceProviderPayLogic();
}
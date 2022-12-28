package com.m_code.Fawry.Services.InternetServices;

import com.m_code.Fawry.Services.AbstractService.AbstractService;
import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Factory Creator Class Service
public abstract class AbstractInternetPaymentService extends AbstractService {
    @Override
    protected ServiceForm creatServiceForm() {
        return new InternetPaymentForm();
    }

    @Override
    protected ServiceHandler creatServiceHandler() {
        return new InternetPaymentHandler();
    }

    @Override
    protected String creatServiceName() {
        return "Internet Payment";
    }
}
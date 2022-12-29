package com.m_code.Fawry.Services.DonationsServices;

import com.m_code.Fawry.Services.AbstractService.AbstractService;
import com.m_code.Fawry.Services.AbstractService.ServiceForm;
import com.m_code.Fawry.Services.AbstractService.ServiceHandler;

//Factory Creator Class
public abstract class AbstractDonationsService extends AbstractService {

    // Factory Method Service
    abstract String getDonationAccount();

    @Override
    protected ServiceForm creatServiceForm() {
        return new DonationsForm();
    }

    @Override
    protected ServiceHandler creatServiceHandler() {
        return new DonationsHandler();
    }

    @Override
    protected String creatServiceName() {
        return "Donations";
    }
}
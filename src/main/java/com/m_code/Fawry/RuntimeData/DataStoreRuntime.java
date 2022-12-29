package com.m_code.Fawry.RuntimeData;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.m_code.Fawry.Payment.models.Transaction;
import com.m_code.Fawry.Services.AbstractService.AbstractService;
import com.m_code.Fawry.Services.DonationsServices.*;
import com.m_code.Fawry.Services.InternetServices.*;
import com.m_code.Fawry.Services.LandlineServices.*;
import com.m_code.Fawry.Services.MobileServices.*;

//Singelton
@Component
public class DataStoreRuntime {
    private ArrayList<AbstractService> services = new ArrayList<AbstractService>();
    private ArrayList<Transaction> refundServices = new ArrayList<Transaction>();
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Transaction> getRefundServices() {
        return refundServices;
    }

    public ArrayList<AbstractService> getServices() {
        return services;
    }

    public ArrayList<String> getServicesNames() {
        ArrayList<String> servicesNames = new ArrayList<String>();
        for (AbstractService service : services) {
            if (!servicesNames.contains(service.getServiceName())) {
                servicesNames.add(service.getServiceName());
            }
        }
        return servicesNames;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void addRefund(Transaction transaction) {
        refundServices.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public void removeRefund(Transaction transaction) {
        refundServices.remove(transaction);
    }

    private DataStoreRuntime() {
        services.add(new EtisalatMobileRecharge());
        services.add(new OrangeMobileRecharge());
        services.add(new VodafoneMobileRecharge());
        services.add(new WeMobileRecharge());

        services.add(new EtisalatInternet());
        services.add(new OrangeInternet());
        services.add(new VodafoneInternet());
        services.add(new WeInternet());

        services.add(new LandlineMonthly());
        services.add(new LandlineQuarterYearly());

        services.add(new Hospital75375());
        services.add(new MagdyYaacoubHospital());
    }

}

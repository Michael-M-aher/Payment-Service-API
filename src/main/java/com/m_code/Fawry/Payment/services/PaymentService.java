package com.m_code.Fawry.Payment.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Payment.CreditCardDto;
import com.m_code.Fawry.RuntimeData.DataStoreRuntime;
import com.m_code.Fawry.Services.AbstractService.AbstractService;
import com.m_code.Fawry.Services.AbstractService.ServiceForm;

@Service
public class PaymentService {

    @Autowired
    BalanceService Bs;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    DataStoreRuntime dts;

    private AbstractService getServiceByName(String name) {
        ArrayList<AbstractService> services = dts.getServices();
        AbstractService service = null;
        for (AbstractService s : services) {
            if (s.getServiceProviderName().equals(name)) {
                service = s;
            }
        }
        return service;
    }

    public ResponseEntity<?> payBalance(String username, String name, ServiceForm serviceForm) {
        AbstractService service = getServiceByName(name);
        if (service == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Service found with this name");
        } else {
            service.setServiceForm(serviceForm);
            float bill = service.getBill();
            if (Bs.decreaseBalance(username, bill)) {
                service.pay();
                return ResponseEntity.ok("Payment Successful" + bill);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not enough balance");
            }
        }

    }

    public ResponseEntity<?> payCreditCard(CreditCardDto credit, String name, ServiceForm serviceForm) {
        AbstractService service = getServiceByName(name);
        if (service == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Service found with this name");
        } else {
            service.setServiceForm(serviceForm);
            float bill = service.getBill();
            if (credit.decreaseBalance(bill)) {
                service.pay();
                return ResponseEntity.ok("Payment Successful" + bill);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not enough balance");
            }
        }

    }

    public ResponseEntity<?> getBill(String name, ServiceForm serviceForm) {
        AbstractService service = getServiceByName(name);
        if (service == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Service found with this name");
        } else {
            service.setServiceForm(serviceForm);
            float bill = service.getBill();
            return ResponseEntity.ok("Your Bill for " + name + " is " + bill + "$");
        }
    }
}

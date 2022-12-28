package com.m_code.Fawry.Services.AbstractService;

//Product B
public abstract class ServiceHandler {
    public abstract void pay(String serviceRequest, ServiceForm serviceForm);

    public abstract float getBill(String serviceRequest, ServiceForm serviceForm);
}

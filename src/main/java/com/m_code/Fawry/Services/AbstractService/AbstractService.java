package com.m_code.Fawry.Services.AbstractService;

import java.util.ArrayList;
import com.m_code.Fawry.Discount.Discount;
import com.m_code.Fawry.Discount.DiscountType;

//Abstract Factory Class
public abstract class AbstractService {
    protected String serviceName = creatServiceName();
    protected String serviceProviderName = creatserviceProviderName();
    protected Boolean COD = allowCod();
    protected ArrayList<Discount> discounts = new ArrayList<Discount>();

    protected ServiceForm serviceForm = creatServiceForm();

    public void setServiceForm(ServiceForm serviceForm) {
        this.serviceForm = serviceForm;
    };

    protected ServiceHandler serviceHandler = creatServiceHandler();

    protected abstract ServiceForm creatServiceForm();

    protected abstract ServiceHandler creatServiceHandler();

    protected abstract String creatServiceName();

    protected abstract String creatserviceProviderName();

    protected abstract Boolean allowCod();

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    protected Boolean getCOD() {
        return COD;
    }

    // notify Method
    public void notifyAddDiscount(Discount discount) {
        discounts.add(discount);

    }

    // notify Method
    public void notifyRemoveDiscount(Discount discount) {
        discounts.remove(discount);

    }

    public final void pay() {
        serviceProviderPayLogic();
    }

    public final float getBill() {
        float billAmount = serviceProviderGetBillLogic();
        if (applyDiscount(billAmount) != billAmount) {
            billAmount = applyDiscount(billAmount);
        }
        return billAmount;
    }

    private float applyDiscount(float amount) {
        float discountAmount = 0;
        for (Discount discount : discounts) {
            if (discount.getDiscountType().equals(DiscountType.Overall)) {
                // && !User.getInstance().getTransactions().isEmpty()) {
                continue;
            }
            discountAmount += discount.getDiscount();
        }
        return amount - (discountAmount * amount);
    }

    protected abstract float serviceProviderGetBillLogic();

    protected abstract void serviceProviderPayLogic();
}
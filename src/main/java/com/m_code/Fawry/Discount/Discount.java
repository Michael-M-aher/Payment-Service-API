package com.m_code.Fawry.Discount;

public class Discount {
    private float DiscountAmount;
    private DiscountType discountType;

    public Discount(float discountAmount, DiscountType discountType) {
        this.DiscountAmount = discountAmount;
        this.discountType = discountType;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public float getDiscount() {
        return DiscountAmount;
    }

    public void setDiscount(float Discount) {
        this.DiscountAmount = Discount;
    }

}

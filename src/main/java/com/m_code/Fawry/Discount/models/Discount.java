package com.m_code.Fawry.Discount.models;

public class Discount {
    private float DiscountAmount;
    private DiscountType discountType;
    private int id;

    public int getId() {
        return id;
    }

    public Discount(int id, float discountAmount, DiscountType discountType) {
        this.id = id;
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

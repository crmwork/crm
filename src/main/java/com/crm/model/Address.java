package com.crm.model;

public class Address {
    private Integer addressId;

    private String shippingAddress;

    private String shippingPoBox;

    private String shippingCity;

    private String shippingState;

    private String shippingCode;

    private String shippingCountry;

    private String billingAddress;

    private String billingPoBox;

    private String billingCity;

    private String billingState;

    private String billingCode;

    private String billingCountry;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
    }

    public String getShippingPoBox() {
        return shippingPoBox;
    }

    public void setShippingPoBox(String shippingPoBox) {
        this.shippingPoBox = shippingPoBox == null ? null : shippingPoBox.trim();
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity == null ? null : shippingCity.trim();
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState == null ? null : shippingState.trim();
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry == null ? null : shippingCountry.trim();
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress == null ? null : billingAddress.trim();
    }

    public String getBillingPoBox() {
        return billingPoBox;
    }

    public void setBillingPoBox(String billingPoBox) {
        this.billingPoBox = billingPoBox == null ? null : billingPoBox.trim();
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity == null ? null : billingCity.trim();
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState == null ? null : billingState.trim();
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode == null ? null : billingCode.trim();
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry == null ? null : billingCountry.trim();
    }
}
package com.crm.model;

import java.util.Date;

public class Product {
    private Integer productId;

    private String productName;

    private String productNumber;

    private String partNumber;

    private Date saleStartDate;

    private String manufacturer;

    private String productCategory;

    private Date supportStart;

    private Date supportExpire;

    private String vandorName;

    private String website;

    private String vandorPartno;

    private String mfrPartno;

    private String serialNo;

    private String glAccount;

    private Double unitPrice;

    private String commissionRate;

    private String stock;

    private String productImage;

    private String description;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber == null ? null : partNumber.trim();
    }

    public Date getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(Date saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory == null ? null : productCategory.trim();
    }

    public Date getSupportStart() {
        return supportStart;
    }

    public void setSupportStart(Date supportStart) {
        this.supportStart = supportStart;
    }

    public Date getSupportExpire() {
        return supportExpire;
    }

    public void setSupportExpire(Date supportExpire) {
        this.supportExpire = supportExpire;
    }

    public String getVandorName() {
        return vandorName;
    }

    public void setVandorName(String vandorName) {
        this.vandorName = vandorName == null ? null : vandorName.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getVandorPartno() {
        return vandorPartno;
    }

    public void setVandorPartno(String vandorPartno) {
        this.vandorPartno = vandorPartno == null ? null : vandorPartno.trim();
    }

    public String getMfrPartno() {
        return mfrPartno;
    }

    public void setMfrPartno(String mfrPartno) {
        this.mfrPartno = mfrPartno == null ? null : mfrPartno.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getGlAccount() {
        return glAccount;
    }

    public void setGlAccount(String glAccount) {
        this.glAccount = glAccount == null ? null : glAccount.trim();
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate == null ? null : commissionRate.trim();
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock == null ? null : stock.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
package com.crm.model;

import java.util.Date;

public class Campaign {
    private Integer campaignId;

    private Integer campaignNo;

    private String campaignName;

    private String assignedTo;

    private String campaignStatus;

    private String campaignType;

    private Integer productId;

    private String targetAudience;

    private Date expectedCloseDate;

    private String sponsor;

    private Integer targetSize;

    private Date createTime;

    private Date modifyTime;

    private Integer numSent;

    private Double actualCost;

    private Double budgetCost;

    private Integer expectedResponse;

    private Integer expectedSalesCount;

    private Integer expectedResponseCount;

    private Integer actualRoi;

    private Integer expectedRoi;

    private Integer actualSalesCount;

    private Integer expectedRevenue;

    private String descriptionDetails;

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCampaignNo() {
        return campaignNo;
    }

    public void setCampaignNo(Integer campaignNo) {
        this.campaignNo = campaignNo;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo == null ? null : assignedTo.trim();
    }

    public String getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(String campaignStatus) {
        this.campaignStatus = campaignStatus == null ? null : campaignStatus.trim();
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType == null ? null : campaignType.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience == null ? null : targetAudience.trim();
    }

    public Date getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate(Date expectedCloseDate) {
        this.expectedCloseDate = expectedCloseDate;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public Integer getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(Integer targetSize) {
        this.targetSize = targetSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getNumSent() {
        return numSent;
    }

    public void setNumSent(Integer numSent) {
        this.numSent = numSent;
    }

    public Double getActualCost() {
        return actualCost;
    }

    public void setActualCost(Double actualCost) {
        this.actualCost = actualCost;
    }

    public Double getBudgetCost() {
        return budgetCost;
    }

    public void setBudgetCost(Double budgetCost) {
        this.budgetCost = budgetCost;
    }

    public Integer getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(Integer expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public Integer getExpectedSalesCount() {
        return expectedSalesCount;
    }

    public void setExpectedSalesCount(Integer expectedSalesCount) {
        this.expectedSalesCount = expectedSalesCount;
    }

    public Integer getExpectedResponseCount() {
        return expectedResponseCount;
    }

    public void setExpectedResponseCount(Integer expectedResponseCount) {
        this.expectedResponseCount = expectedResponseCount;
    }

    public Integer getActualRoi() {
        return actualRoi;
    }

    public void setActualRoi(Integer actualRoi) {
        this.actualRoi = actualRoi;
    }

    public Integer getExpectedRoi() {
        return expectedRoi;
    }

    public void setExpectedRoi(Integer expectedRoi) {
        this.expectedRoi = expectedRoi;
    }

    public Integer getActualSalesCount() {
        return actualSalesCount;
    }

    public void setActualSalesCount(Integer actualSalesCount) {
        this.actualSalesCount = actualSalesCount;
    }

    public Integer getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(Integer expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public String getDescriptionDetails() {
        return descriptionDetails;
    }

    public void setDescriptionDetails(String descriptionDetails) {
        this.descriptionDetails = descriptionDetails == null ? null : descriptionDetails.trim();
    }
}
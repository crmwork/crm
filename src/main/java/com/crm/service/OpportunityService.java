package com.crm.service;

import com.crm.model.Opportunity;

import java.util.List;
import java.util.Map;
public interface OpportunityService {

//    public Opportunity findById(int opportunityId);

//    public List<Opportunity> selectAll();

    public long getTotal(Map<String, Object> map);

    public int addOpportunity(Opportunity opportunity);

    public Opportunity getOpportunity(int id);

    public int updateOpportunity(Opportunity opportunity);

    public int updateImage(Integer opportunityId, String opportunityImage);

    public List<Opportunity> find(Map<String, Object> map);

}

package com.crm.dao;

import com.crm.model.Opportunity;

import java.util.List;
import java.util.Map;

public interface OpportunityMapper {
    int deleteByPrimaryKey(Integer opportunityId);

    int insert(Opportunity record);

    int insertSelective(Opportunity record);

    Opportunity selectByPrimaryKey(Integer opportunityId);

    int updateByPrimaryKeySelective(Opportunity record);

    int updateByPrimaryKey(Opportunity record);

    public List<Opportunity> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);
}
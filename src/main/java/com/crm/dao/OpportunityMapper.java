package com.crm.dao;

import com.crm.model.Opportunity;

public interface OpportunityMapper {
    int deleteByPrimaryKey(Integer opportunityId);

    int insert(Opportunity record);

    int insertSelective(Opportunity record);

    Opportunity selectByPrimaryKey(Integer opportunityId);

    int updateByPrimaryKeySelective(Opportunity record);

    int updateByPrimaryKey(Opportunity record);
}
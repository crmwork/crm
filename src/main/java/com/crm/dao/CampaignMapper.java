package com.crm.dao;

import com.crm.model.Campaign;

public interface CampaignMapper {
    int deleteByPrimaryKey(Integer campaignId);

    int insert(Campaign record);

    int insertSelective(Campaign record);

    Campaign selectByPrimaryKey(Integer campaignId);

    int updateByPrimaryKeySelective(Campaign record);

    int updateByPrimaryKey(Campaign record);
}
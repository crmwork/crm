package com.crm.dao;

import com.crm.model.Campaign;

import java.util.List;
import java.util.Map;

public interface CampaignMapper {
    int deleteByPrimaryKey(Integer campaignId);

    int insert(Campaign record);

    int insertSelective(Campaign record);

    Campaign selectByPrimaryKey(Integer campaignId);

    int updateByPrimaryKeySelective(Campaign record);

    int updateByPrimaryKey(Campaign record);

    public List<Campaign> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);
}
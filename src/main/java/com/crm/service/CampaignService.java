package com.crm.service;


import com.crm.model.Campaign;

import java.util.List;
import java.util.Map;
public interface CampaignService {

    Campaign findById(int campaignId);

    List<Campaign> selectAll();

    int addCampaign(Campaign campaign);

    int updateCampaign(Campaign campaign);

    int deleteCampaign(int id);

    int updateImage(Integer campaignId, String campaignImage);

    public List<Campaign> find(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);

}

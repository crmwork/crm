package com.crm.dao;

import com.crm.model.Organization;

import java.util.List;
import java.util.Map;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer organizationId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    /**
     *
     * @param map
     * @return集合
     */
    public List<Organization> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);
}
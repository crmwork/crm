package com.crm.service.impl;

import com.crm.dao.OrganizationMapper;
import com.crm.model.Organization;
import com.crm.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/11/011.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    private OrganizationMapper organizationMapper;

    public Organization getOrganization(int id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    public List<Organization> find(Map<String, Object> map) {
        return organizationMapper.find(map);
    }

    public long getTotal(Map<String, Object> map) {
        return organizationMapper.getTotal(map);
    }

    public int addOrganization(Organization organization) {
        Date date = new Date();
        organization.setCreateTime(date);
        return organizationMapper.insertSelective(organization);
    }

    public int updateOrganization(Organization organization) {
        Date date = new Date();
        organization.setModifyTime(date);
        return organizationMapper.updateByPrimaryKeySelective(organization);
    }

}

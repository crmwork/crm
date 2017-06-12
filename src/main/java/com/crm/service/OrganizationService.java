package com.crm.service;

import com.crm.model.Organization;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/11/011.
 */
public interface OrganizationService {

    public Organization getOrganization(int id);

    public List<Organization> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);

    public int addOrganization(Organization organization);

    public int updateOrganization(Organization organization);
}

package com.crm.dao;

import com.crm.model.Contact;

import java.util.List;
import java.util.Map;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer contactId);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer contactId);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

    public List<Contact> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);
}
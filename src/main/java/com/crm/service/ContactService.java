package com.crm.service;


import com.crm.model.Contact;

import java.util.List;
import java.util.Map;

public interface ContactService {
    Contact findById(int contactId);

    List<Contact> selectAll();

    int addContact(Contact contact);

    int updateContact(Contact contact);

    int updateImage(Integer contactId, String contactImage);

    public List<Contact> find(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);
}

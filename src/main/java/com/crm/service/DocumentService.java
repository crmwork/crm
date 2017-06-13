package com.crm.service;

import com.crm.model.Document;

import java.util.List;
import java.util.Map;


public interface DocumentService {

    public Document getDocument(int id);

    public List<Document> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);

    public int addDocument(Document document);

    public int updateDocument(Document document);
}

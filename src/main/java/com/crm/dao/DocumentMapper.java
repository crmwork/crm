package com.crm.dao;

import com.crm.model.Document;
import java.util.List;
import java.util.Map;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentId);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentId);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);

    public List<Document> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);
}
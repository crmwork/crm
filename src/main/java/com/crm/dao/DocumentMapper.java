package com.crm.dao;

import com.crm.model.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentId);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentId);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}
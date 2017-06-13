package com.crm.dao;

import com.crm.model.Project;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    public List<Project> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);
}
package com.crm.service;

import com.crm.model.Project;

import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2017/6/12.
 */
public interface ProjectService {
    public Project getProject(int id);

    public List<Project> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);

    public int addProject(Project project);

    public int updateProject(Project project);
}

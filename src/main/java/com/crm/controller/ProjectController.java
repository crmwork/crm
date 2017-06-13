package com.crm.controller;


import com.crm.model.Project;
import com.crm.service.ProjectService;
import com.crm.util.DateJsonValueProcessor;
import com.crm.util.Json;
import com.crm.util.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2017/6/12.
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController {
    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(OrganizationController.class);
    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/List",method = RequestMethod.POST)
    @ResponseBody
    //搜索功能，返回json
    //数据从前端在这里传入后台,除了page和rows，还有campaign实体的属性（作为搜索项），允许其中一些为空
    public Object ProjectList(@RequestParam(value = "page",required = false)String page,
                                   @RequestParam(value = "rows",required = false)String rows,
                                   Project project){
        //初始化分页信息
        PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));

        Map<String,Object> map = new HashMap<String, Object>();

        //接收到的campaign实体，我只需要以下四个字段的信息（可以是这四个字段的一部分）。不为空的属性加入map容器中
        if (project.getProjectName() != null){
            map.put("organizationName",project.getProjectName());
        }

        if (project.getProcess()!= null){
            map.put("organizationName",project.getProcess());
        }

        //将分页信息的起始页和每一页的内容添加到map容器中
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        //获取Campaign信息的所有内容
        List<Project>projects = projectService.find(map);
        Long total=projectService.getTotal(map);

        JSONObject result=new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONArray jsonArray= JSONArray.fromObject(projects,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total",total);
        log.debug("广告列表"+result.toString());
        return result;
    }

    //增加项目
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addProject(Project project) {
        //获取上面取得的json数据
        Json json = new Json();
        //添加失败。必要字段信息缺失
        if(project.getProjectName()==null){
            log.debug("添加项目失败"+" 必要信息没有填写");
            json.setSuccess(false);
            json.setMsg("添加项目失败"+" 必要信息广告名称或指定处理人没有填写");
        }
        else{
            //核心语句。判断操作是否成功
            int result= projectService.addProject(project);

            if (result > 0){
                log.debug("添加项目成功");
                json.setSuccess(true);
            }else {
                log.debug("添加项目失败");
                json.setSuccess(false);
                json.setMsg("添加项目失败");
            }
        }
        return json;
    }

    //更新广告
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateProject(Project project){
        Json json = new Json();
        if (project.getProjectName() == null){
            log.debug("更新项目失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("更新项目失败"+":id不能为空");
        }else {
            int result = projectService.updateProject(project);

            if (result > 0){
                log.debug("更新项目"+project.getProjectId()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("更新项目失败");
                json.setSuccess(false);
                json.setMsg("更新项目失败");
            }
        }
        return json;
    }

    //跳转到项目详情页面
    //异常处理
    @RequestMapping(value = "/{projectId}",method = RequestMethod.GET)
    public String getProject(@PathVariable("projectId")String projectId){
        if (projectId == null){
            return "/404";
        }
        return "/project/"+projectId;
    }

    //获取项目详情
    @RequestMapping(value = "/{projectId}",method = RequestMethod.POST)
    @ResponseBody
    public Object getProjectDetail(@PathVariable("projectId")Integer projectId){
        Json json = new Json();
        if (projectId == null){
            log.debug("项目详情获取失败"+":id不准确");
            json.setSuccess(false);
            json.setMsg("项目详情获取失败"+":id不准确");
            return json;
        }

        Project project = projectService.getProject(projectId);

        if (project != null){
            log.debug("查询项目"+projectId+"成功");
            json.setSuccess(true);
            json.setObj(project);
        }else {
            log.debug("查询项目"+projectId+"失败");
            json.setSuccess(false);
            json.setMsg("查询项目"+projectId+"失败");
        }
        return json;
    }


}

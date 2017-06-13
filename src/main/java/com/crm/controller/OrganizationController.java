package com.crm.controller;

import com.crm.model.Organization;
import com.crm.service.OrganizationService;
import com.crm.util.DateJsonValueProcessor;
import com.crm.util.Json;
import com.crm.util.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiechur
 */
@Controller
@RequestMapping("organization")
public class OrganizationController {
    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;


    /**
     * 客户列表
     * 包括搜索功能（可选搜索）
     * 返回结果：json
     * example：
     * {
     *     “success”:true
     * }
     * @param page  页号
     * @param rows  行数
     * @param billingCity
     * @param organization
     * @return
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Object organizationList(@RequestParam(value = "page",required = false)String page,
                                   @RequestParam(value = "rows",required = false)String rows,
                                   @RequestParam(value = "billingCity",required = false)String billingCity,
                                   Organization organization){
        PageBean pageBean = null;
        if (page != null && rows != null){
            pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        }


        Map<String,Object> map = new HashMap<String, Object>();

        if (organization.getOrganizationName() != null){
            map.put("organizationName",organization.getOrganizationName());
        }
        if (billingCity != null){
            map.put("billingCity",billingCity);
        }
        if (organization.getWebsite() != null){
            map.put("website",organization.getWebsite());
        }
        if (organization.getPhone() != null){
            map.put("phone",organization.getPhone());
        }
        if (organization.getAssignedTo() != null){
            map.put("assignedTo",organization.getAssignedTo());
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        List<Organization> organizations = organizationService.find(map);
        Long total=organizationService.getTotal(map);
        JSONObject result=new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONArray jsonArray= JSONArray.fromObject(organizations,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total",total);
        log.debug("客户列表"+result.toString());
        return result;
    }


    /**
     * 增加客户
     * 必须
     * @param organization
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Object addOrganization(Organization organization){
        Json json = new Json();
        if (organization.getOrganizationName() == null || organization.getAssignedTo() == null){
            log.debug("添加客户失败"+"必要信息没有填写");
            json.setSuccess(false);
            json.setMsg("添加客户失败"+"必要信息组织名称或指定处理人没有填写");
        }else {
            int result = organizationService.addOrganization(organization);

            if (result > 0){
                log.debug("添加客户成功");
                json.setSuccess(true);
            }else {
                log.debug("添加客户失败");
                json.setSuccess(false);
                json.setMsg("添加客户失败");
            }
        }
        return json;
    }

    /**
     * 更新客户
     * @param organization
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateOrganization(Organization organization){
        Json json = new Json();
        if (organization.getOrganizationId() == null){
            log.debug("更新客户失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("更新客户失败"+":id不能为空");
        }else {
            int result = organizationService.updateOrganization(organization);
            if (result > 0){
                log.debug("更新客户"+organization.getOrganizationId()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("更新客户失败");
                json.setSuccess(false);
                json.setMsg("更新客户失败");
            }
        }
        return json;
    }

    /**
     * 跳转到客户详情页面
     * @param organizationId
     * @return
     */
//    @RequestMapping(value = "/{organizationId}",method = RequestMethod.GET)
//    public String getOrganization(@PathVariable("organizationId")String organizationId){
//        if (organizationId == null){
//            return "/404";
//        }
//        return "/organization/"+organizationId;
//    }

    /**
     * 获取客户详情
     * @param organizationId
     * @return
     */
    @RequestMapping(value = "/{organizationId}")
    @ResponseBody
    public Object getOrganizationDetail(@PathVariable("organizationId")Integer organizationId){
        Json json = new Json();
        if (organizationId == null){
            log.debug("客户详情获取失败"+":id不准确");
            json.setSuccess(false);
            json.setMsg("客户详情获取失败"+":id不准确");
            return json;
        }
        Organization organization = organizationService.getOrganization(organizationId);

        if (organization != null){
            log.debug("查询客户"+organizationId+"成功");
            json.setSuccess(true);
            json.setObj(organization);
        }else {
            log.debug("查询客户"+organizationId+"失败");
            json.setSuccess(false);
            json.setMsg("查询客户"+organizationId+"失败");
        }
        return json;
    }


}

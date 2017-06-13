package com.crm.controller;

import com.crm.model.Opportunity;
import com.crm.service.OpportunityService;
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
 * 机会 的控制器
 * @author yi
 */
@Controller
@RequestMapping(value = "/opportunity")
public class OpportunityController{
    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(OrganizationController.class);
    @Resource
    private OpportunityService opportunityService;


    @RequestMapping(value = "/List",method = RequestMethod.POST)
    @ResponseBody
    //搜索功能，返回json
    //数据从前端在这里传入后台,除了page和rows，还有campaign实体的属性（作为搜索项），允许其中一些为空
    public Object opportunityList(@RequestParam(value = "page",required = false)String page,
                                   @RequestParam(value = "rows",required = false)String rows,
                                   Opportunity opportunity) {
        //初始化分页信息
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));

        Map<String, Object> map = new HashMap<String, Object>();

        if (opportunity.getAssignedTo()!= null){
            map.put("assignedTo",opportunity.getAssignedTo());
        }

        if (opportunity.getOpportunityName()!= null){
            map.put("opportunityName",opportunity.getOpportunityName());
        }

        if (opportunity.getLeadSource()!= null){
            map.put("leadSource",opportunity.getLeadSource());
        }

        //将分页信息的起始页和每一页的内容添加到map容器中
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        List<Opportunity>opportunities = opportunityService.find(map);
        Long total=opportunityService.getTotal(map);

        JSONObject result=new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONArray jsonArray= JSONArray.fromObject(opportunities,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total",total);
        log.debug("机会列表"+result.toString());
        return result;
    }

    //增加广告
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addOpportunity(Opportunity opportunity) {
        //获取上面取得的json数据
        Json json = new Json();
        //添加失败。必要字段信息缺失
        if(opportunity.getAssignedTo()==null||opportunity.getOpportunityName()==null){
            log.debug("添加机会失败"+" 必要信息没有填写");
            json.setSuccess(false);
            json.setMsg("添加机会失败"+" 必要信息机会名称或指定处理人没有填写");
        }
        else{
            //核心语句。判断操作是否成功
            int result= opportunityService.addOpportunity(opportunity);

            if (result > 0){
                log.debug("添加机会成功");
                json.setSuccess(true);
            }else {
                log.debug("添加机会失败");
                json.setSuccess(false);
                json.setMsg("添加机会失败");
            }
        }
        return json;
    }

    //更新广告
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateOpportunity(Opportunity opportunity){
        Json json = new Json();
        if (opportunity.getOpportunityId() == null){
            log.debug("更新机会失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("更新机会失败"+":id不能为空");
        }else {
            int result = opportunityService.updateOpportunity(opportunity);

            if (result > 0){
                log.debug("更新机会"+opportunity.getOpportunityId()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("更新机会失败");
                json.setSuccess(false);
                json.setMsg("更新机会失败");
            }
        }
        return json;
    }

    @RequestMapping(value = "/{opportunityId}",method = RequestMethod.GET)
    public String getOpportunity(@PathVariable("opportunityId")String opportunityId){
        if (opportunityId == null){
            return "/404";
        }
        return "/opportunity/"+opportunityId;
    }

    //获取机会详情
    @RequestMapping(value = "/{opportunityId}",method = RequestMethod.POST)
    @ResponseBody
    public Object getOpportunityDetail(@PathVariable("opportunityId")Integer opportunityId){
        Json json = new Json();
        if (opportunityId == null){
            log.debug("联系人详情获取失败"+":id不准确");
            json.setSuccess(false);
            json.setMsg("联系人详情获取失败"+":id不准确");
            return json;
        }

        Opportunity opportunity = opportunityService.getOpportunity(opportunityId);

        if (opportunity != null){
            log.debug("查询联系人"+opportunityId+"成功");
            json.setSuccess(true);
            json.setObj(opportunityId);
        }else {
            log.debug("查询联系人"+opportunityId+"失败");
            json.setSuccess(false);
            json.setMsg("查询联系人"+opportunityId+"失败");
        }
        return json;
    }


}

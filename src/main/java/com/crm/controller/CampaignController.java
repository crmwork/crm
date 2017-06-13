package com.crm.controller;

import com.crm.model.Campaign;
import com.crm.service.CampaignService;
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
 * 用户 的控制器
 * @author yi
 */
@Controller
@RequestMapping(value = "/campaign")
public class CampaignController{

    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(OrganizationController.class);
    @Resource
    private CampaignService campaignService;

    @RequestMapping(value = "/List",method = RequestMethod.POST)
    @ResponseBody
    //搜索功能，返回json
    //数据从前端在这里传入后台,除了page和rows，还有campaign实体的属性（作为搜索项），允许其中一些为空
    public Object CampaignList(@RequestParam(value = "page",required = false)String page,
                                   @RequestParam(value = "rows",required = false)String rows,
                                   Campaign campaign){
        //初始化分页信息
        PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));

        Map<String,Object> map = new HashMap<String, Object>();

        //接收到的campaign实体，我只需要以下四个字段的信息（可以是这四个字段的一部分）。不为空的属性加入map容器中
        if (campaign.getCampaignName() != null){
            map.put("organizationName",campaign.getCampaignName());
        }
        if (campaign.getCampaignType() != null){
            map.put("organizationName",campaign.getCampaignType() != null);
        }
        if (campaign.getCampaignNo() != null){
            map.put("organizationName",campaign.getCampaignNo() != null);
        }
        if (campaign.getAssignedTo() != null){
            map.put("organizationName",campaign.getAssignedTo() != null);
        }
        //将分页信息的起始页和每一页的内容添加到map容器中
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        //获取Campaign信息的所有内容
        List<Campaign>campaigns = campaignService.find(map);
        Long total=campaignService.getTotal(map);

        JSONObject result=new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONArray jsonArray= JSONArray.fromObject(campaigns,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total",total);
        log.debug("广告列表"+result.toString());
        return result;
    }

//增加广告
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addCampaign(Campaign campaign) {
        //获取上面取得的json数据
        Json json = new Json();
        //添加失败。必要字段信息缺失
        if(campaign.getCampaignName()==null||campaign.getAssignedTo()==null){
            log.debug("添加广告失败"+" 必要信息没有填写");
            json.setSuccess(false);
            json.setMsg("添加广告失败"+" 必要信息广告名称或指定处理人没有填写");
        }
        else{
            //核心语句。判断操作是否成功
            int result= campaignService.addCampaign(campaign);

            if (result > 0){
                log.debug("添加广告成功");
                json.setSuccess(true);
            }else {
                log.debug("添加广告失败");
                json.setSuccess(false);
                json.setMsg("添加广告失败");
            }
        }
        return json;
    }

    //更新广告
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateCampaign(Campaign campaign){
        Json json = new Json();
        if (campaign.getCampaignId() == null){
            log.debug("更新广告失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("更新广告失败"+":id不能为空");
        }else {
            int result = campaignService.updateCampaign(campaign);

            if (result > 0){
                log.debug("更新广告"+campaign.getCampaignId()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("更新广告失败");
                json.setSuccess(false);
                json.setMsg("更新广告失败");
            }
        }
        return json;
    }


    //删除广告
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteCampaign(Campaign campaign){
        Json json = new Json();
        if (campaign.getCampaignId() == null){
            log.debug("删除广告失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("删除广告失败"+":id不能为空");
        }else {
            int result = campaignService.deleteCampaign(campaign.getCampaignId());

            if (result > 0){
                log.debug("删除广告"+campaign.getCampaignId()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("删除广告失败");
                json.setSuccess(false);
                json.setMsg("删除广告失败");
            }
        }
        return json;
    }

    //跳转到广告详情页面
    //异常处理
    @RequestMapping(value = "/{campaignId}",method = RequestMethod.GET)
    public String getCampaign(@PathVariable("campaignId")String campaignId){
        if (campaignId == null){
            return "/404";
        }
        return "/campaign/"+campaignId;
    }

    //获取广告详情
    @RequestMapping(value = "/{campaignId}",method = RequestMethod.POST)
    @ResponseBody
    public Object getCampaignDetail(@PathVariable("campaignId")Integer campaignId){
        Json json = new Json();
        if (campaignId == null){
            log.debug("广告详情获取失败"+":id不准确");
            json.setSuccess(false);
            json.setMsg("广告详情获取失败"+":id不准确");
            return json;
        }

        Campaign campaign = campaignService.findById(campaignId);

        if (campaign != null){
            log.debug("查询广告"+campaignId+"成功");
            json.setSuccess(true);
            json.setObj(campaign);
        }else {
            log.debug("查询广告"+campaignId+"失败");
            json.setSuccess(false);
            json.setMsg("查询广告"+campaignId+"失败");
        }
        return json;
    }


}

package com.crm.controller;

import com.crm.model.Contact;
import com.crm.service.ContactService;
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
@RequestMapping(value = "/contact")
public class ContactController{

    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(OrganizationController.class);

    @Resource
    private ContactService contactService;

    @RequestMapping(value = "/List",method = RequestMethod.POST)
    @ResponseBody
    public Object contactList(@RequestParam(value = "page",required = false)String page,
                                   @RequestParam(value = "rows",required = false)String rows,
                                   Contact contact){
        //初始化分页信息
        PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));

        Map<String,Object> map = new HashMap<String, Object>();

        if (contact.getFirstName() != null){
            map.put("contactName",contact.getFirstName());
        }

        if (contact.getLastName() != null){
            map.put("contactName",contact.getLastName());
        }

        if (contact.getAssignedTo() != null){
            map.put("contactName",contact.getAssignedTo());
        }

        if (contact.getEmail() != null){
            map.put("contactName",contact.getEmail());
        }

        //将分页信息的起始页和每一页的内容添加到map容器中
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        //获取Campaign信息的所有内容
        List<Contact>contacts = contactService.find(map);
        Long total=contactService.getTotal(map);

        JSONObject result=new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONArray jsonArray= JSONArray.fromObject(contacts,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total",total);
        log.debug("联系人列表"+result.toString());
        return result;
    }


    //增加联系人
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addContact(Contact contact) {
        //获取上面取得的json数据
        Json json = new Json();
        //添加失败。必要字段信息缺失
        if(contact.getAssignedTo()==null||contact.getFirstName()==null||contact.getLastName()==null){
            log.debug("添加联系人失败"+" 必要信息没有填写");
            json.setSuccess(false);
            json.setMsg("添加联系人失败"+" 必要信息联系人名称或指定处理人没有填写");
        }
        else{
            //核心语句。判断操作是否成功
            int result = contactService.addContact(contact);

            if (result > 0){
                log.debug("添加联系人成功");
                json.setSuccess(true);
            }else {
                log.debug("添加联系人失败");
                json.setSuccess(false);
                json.setMsg("添加联系人失败");
            }
        }
        return json;
    }

    //更新联系人
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateContact(Contact contact){
        Json json = new Json();
        if (contact.getContactId() == null){
            log.debug("更新联系人失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("更新联系人失败"+":id不能为空");
        }else {
            int result = contactService.updateContact(contact);

            if (result > 0){
                log.debug("更新联系人"+contact.getContactId()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("更新联系人失败");
                json.setSuccess(false);
                json.setMsg("更新联系人失败");
            }
        }
        return json;
    }



    //跳转到组织详情页面
    //异常处理
    @RequestMapping(value = "/{contactId}",method = RequestMethod.GET)
    public String getContact(@PathVariable("contactId")String contactId){
        if (contactId == null){
            return "/404";
        }
        return "/contact/"+contactId;
    }

    //获取联系人详情
    @RequestMapping(value = "/{contactId}",method = RequestMethod.POST)
    @ResponseBody
    public Object getContactDetail(@PathVariable("contactId")Integer contactId){
        Json json = new Json();
        if (contactId == null){
            log.debug("联系人详情获取失败"+":id不准确");
            json.setSuccess(false);
            json.setMsg("联系人详情获取失败"+":id不准确");
            return json;
        }

        Contact contact = contactService.findById(contactId);
        if (contact != null){
            log.debug("查询联系人"+contactId+"成功");
            json.setSuccess(true);
            json.setObj(contact);
        }else {
            log.debug("查询联系人"+contactId+"失败");
            json.setSuccess(false);
            json.setMsg("查询联系人"+contactId+"失败");
        }
        return json;
    }



}

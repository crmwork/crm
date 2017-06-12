package com.crm.controller;

import com.crm.model.User;
import com.crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 的控制器
 * @author xiechur
 */
@Controller
@RequestMapping(value = "/user")
public class UserController{

    @Resource
    private UserService userService;


    /**
     * 查询用户列表
     */
    @RequestMapping(value = "userList")
    @ResponseBody
    public Object selectUser(){
        List<User> userList = userService.selectAll();
        return userList;
    }



}

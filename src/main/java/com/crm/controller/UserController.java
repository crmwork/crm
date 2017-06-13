package com.crm.controller;

import com.crm.common.SpringMvcActionContext;
import com.crm.model.User;
import com.crm.service.UserService;
import com.crm.util.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户 的控制器
 * @author xiechur
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends SpringMvcActionContext{

    @Resource
    private UserService userService;


//    /**
//     * 查询用户列表
//     */
//    @RequestMapping(value = "userList")
//    @ResponseBody
//    public Object selectUser(){
//        List<User> userList = userService.find();
//        Json json = new Json();
//        if (userList != null && userList.size() >= 0){
//            json.setSuccess(true);
//            json.setObj(userList);
//        }else {
//            json.setSuccess(false);
//            json.setMsg("结果为空");
//        }
//        return json;
//    }



    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(User user){
        User result = userService.login(user);
        Json json = new Json();
        if (result != null){
            HttpSession session = getSession();
            session.setAttribute("user",result);
            json.setSuccess(true);
        }else {
            json.setSuccess(false);
            json.setMsg("登录失败");
        }
        return json;
    }


    @RequestMapping(value = "logout")
    public String logout(){
        HttpSession session = getSession();
        session.removeAttribute("user");
        return "/user/login";
    }

}

package com.crm.dao;

import com.crm.model.User;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@RequestParam("userName") String userName,@RequestParam("password")String password);

}
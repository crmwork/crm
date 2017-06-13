package com.crm.service;


import com.crm.model.User;

import java.util.List;
import java.util.Map;
public interface UserService {

    User findById(int userId);

    int add(User user);

    int update(User user);

    /**
     * 用户列表
     * @param map
     * @return
     */
    public List<User> find(Map<String, Object> map);

    /**
     * 列表项数
     * @param map
     * @return
     */
    public long total(Map<String,Object> map);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

}

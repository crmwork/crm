package com.crm.service;


import com.crm.model.User;

import java.util.List;
import java.util.Map;
public interface UserService {

    User findById(int userId);

    List<User> selectAll();

    int add(User user);

    int update(User user);

    int updateImage(Integer userId, String userImage);

    /**
     * 用户查询
     * @param map
     * @return
     */
    public List<User> find(Map<String, Object> map);

}

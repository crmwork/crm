package com.crm.service.impl;

import com.crm.dao.UserMapper;
import com.crm.model.User;
import com.crm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiechur on 2016/8/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    public User findById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> selectAll() {
        return null;
    }

    public int add(User user) {
        return 0;
    }

    public int update(User user) {
        return 0;
    }

    public int updateImage(Integer userId, String userImage) {
        return 0;
    }

    public List<User> find(Map<String, Object> map) {
        return null;
    }

    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    public int delete(Integer userId) {
        return 0;
    }

    public User findByName(String userName) {
        return null;
    }


}

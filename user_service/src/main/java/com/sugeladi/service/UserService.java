package com.sugeladi.service;

import com.sugeladi.mapper.UserMapper;
import com.sugeladi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: cn.itcast
 * @ClassName: serviceUserService
 * @Author: sushengchao
 * @Date: 2019/12/19 18:43
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id){

       return userMapper.selectByPrimaryKey(id);
    }

}

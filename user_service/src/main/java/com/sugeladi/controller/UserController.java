package com.sugeladi.controller;

import com.sugeladi.pojo.User;
import com.sugeladi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: cn.itcast.controller
 * @ClassName: UserController
 * @Author: sushengchao
 * @Date: 2019/12/19 18:45
 * @Description:
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User findById(@PathVariable Integer id){
        System.out.println(id);
        System.out.println("7754385");
        return userService.findById(id);
    }
    @RequestMapping("/5")
    public void findById2(){
        System.out.println("7754385");

    }
}

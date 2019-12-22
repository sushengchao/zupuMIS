package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.PortUnreachableException;

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
        return userService.findById(id);
    }

}

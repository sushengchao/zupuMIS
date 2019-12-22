package cn.itcast.controller;

import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: cn.itcast.controller
 * @ClassName: FeignController
 * @Author: sushengchao
 * @Date: 2019/12/21 21:50
 * @Description:
 */

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    private User  findById(@PathVariable Integer id){

        return userClient.findById(id);
    }

}

package cn.itcast.controller;

import cn.itcast.pojo.User;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Integer id);
}

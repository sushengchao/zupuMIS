package cn.itcast.controller;

import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @PackageName: cn.itcast.controller
 * @ClassName: ConsumerController
 * @Author: sushengchao
 * @Date: 2019/12/19 19:22
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
      //  String url = "http://localhost/user/"+ id;

        //根据服务获取服务集合
        List<ServiceInstance> list = discoveryClient.getInstances("user_service");
        //获得一个服务
        ServiceInstance instance = list.get(0);
        //
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }
}

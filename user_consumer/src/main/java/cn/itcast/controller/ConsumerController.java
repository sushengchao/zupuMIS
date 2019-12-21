package cn.itcast.controller;

import cn.itcast.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    //
//    @HystrixCommand(fallbackMethod = "findByIdfallback")
    @HystrixCommand
    public String findById(@PathVariable("id") Integer id){
      //  String url = "http://localhost/user/"+ id;

       /* //根据服务获取服务集合
        List<ServiceInstance> list = discoveryClient.getInstances("user_service");
        //获得一个服务
        ServiceInstance instance = list.get(0);
        //
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
*/
      //开启负载均衡后
        String url = "http://user-service/user/" + id;
        return   restTemplate.getForObject(url, String.class);

    }

    public String findByIdfallback(Integer id){
        log.error("查询用户信息失败.id:{}",id);
        return "对不起,网络太忙,请刷新重试!";
    }

    public String defaultFallback(){
        return "默认提示：对不起，网络太拥挤了！";
    }
}

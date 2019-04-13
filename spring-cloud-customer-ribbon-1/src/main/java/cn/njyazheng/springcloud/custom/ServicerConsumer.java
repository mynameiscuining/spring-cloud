package cn.njyazheng.springcloud.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServicerConsumer {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;
    //使用虚拟IP
    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        return restTemplate.getForObject("http://provider/get/name/"+1,String.class);
    }

}

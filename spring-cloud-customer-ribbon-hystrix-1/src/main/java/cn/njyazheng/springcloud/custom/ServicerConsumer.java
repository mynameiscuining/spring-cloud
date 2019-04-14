package cn.njyazheng.springcloud.custom;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    //对方法加断路器
    @HystrixCommand(fallbackMethod = "getNameFallbackMethod")
    public String getName(@PathVariable String id){
        return restTemplate.getForObject("http://provider/get/name/"+1,String.class);
    }
    //方法的参数和返回值都要和 @HystrixCommand注解的方法一致
    //请求的微服务异常,将进入此方法
    public String getNameFallbackMethod(String id){
        return "this is Hystrix getNameFallbackMethod";
    }

}

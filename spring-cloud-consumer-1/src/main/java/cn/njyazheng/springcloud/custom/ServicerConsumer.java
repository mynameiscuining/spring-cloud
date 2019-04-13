package cn.njyazheng.springcloud.custom;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServicerConsumer {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${provider.get.name}")
    private  String url;
    //EurekaClient不能使用在注解 @PostConstruct method or in a @Scheduled method
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        return restTemplate.getForObject(url+1,String.class);
    }

}

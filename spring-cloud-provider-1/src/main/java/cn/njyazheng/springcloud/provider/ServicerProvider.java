package cn.njyazheng.springcloud.provider;

import cn.njyazheng.springcloud.domain.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServicerProvider {
    @Value("${auth}")
    private boolean auth;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    //使用EurekaClient实例1
    @GetMapping("/instanceInfo-instance")
    public String eurekaClient() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-1", false);
        return instance.getHomePageUrl();
    }
    //使用EurekaClient实例2
    @GetMapping("/serviceInstance-instance")
    public String discoveryClient() {
        List<ServiceInstance> list = discoveryClient.getInstances("PROVIDER-1");
        return list.toString();
    }

    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        System.out.println(auth);
        return "cuining-provider-1";
    }

    @GetMapping("/user")
    public User getUser(Integer id,String name){
        System.out.println(id+":"+name);
        return new User(1,"cuining");
    }
}

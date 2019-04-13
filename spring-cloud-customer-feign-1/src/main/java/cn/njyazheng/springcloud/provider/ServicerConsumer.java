package cn.njyazheng.springcloud.provider;

import cn.njyazheng.springcloud.domain.User;
import cn.njyazheng.springcloud.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicerConsumer {


    @Autowired
    private ProviderFeign providerFeign;
    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        return  providerFeign.getName(id);
    }

    @GetMapping("/user")
    public User getName(){
        return  providerFeign.getUser(1,"ccc");
    }

}

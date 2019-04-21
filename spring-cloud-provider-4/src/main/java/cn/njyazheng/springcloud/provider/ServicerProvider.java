package cn.njyazheng.springcloud.provider;

import cn.njyazheng.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicerProvider {
    @Value("${auth}")
    private boolean auth;


    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        System.out.println(auth);
        return "cuining-provider-4";
    }

    @GetMapping("/user")
    public User getUser(Integer id,String name){
        System.out.println(id+":"+name);
        return new User(2,"cuining-provider-4");
    }

}

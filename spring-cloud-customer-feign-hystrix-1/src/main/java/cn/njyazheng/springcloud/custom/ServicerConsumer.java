package cn.njyazheng.springcloud.custom;

import cn.njyazheng.springcloud.domain.User;
import cn.njyazheng.springcloud.feign.DisableHystrixWithSingleFeign;
import cn.njyazheng.springcloud.feign.ProviderFeign;
import cn.njyazheng.springcloud.feign.UrlFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicerConsumer {
//    @Autowired
//    private CustomFeign customFeign;

    @Autowired
    private ProviderFeign providerFeign;
    @Autowired
    private UrlFeign urlFeign;

    @Autowired
    private DisableHystrixWithSingleFeign disableHystrixWithSingleFeign;

    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        return  providerFeign.getName(id);
    }
    @GetMapping("/name/{id}")
    public String getName3(@PathVariable String id){
        return  urlFeign.getName(id);
    }
    //测试Defualt协议
//    @GetMapping("/name/{id}")
//    public String getName2(@PathVariable String id){
//        return  customFeign.contributors(id);
//    }
    @GetMapping("/user")
    public User getName(){
        return  providerFeign.getUser(1,"ccc");
    }

    @GetMapping("/provider3/user")
    public User getName2(){
        return  disableHystrixWithSingleFeign.getUser(1,"ccc");
    }

    @GetMapping("/provider3/name/{id}")
    public String getName4(@PathVariable String id){
        return  disableHystrixWithSingleFeign.getName(id);
    }
}

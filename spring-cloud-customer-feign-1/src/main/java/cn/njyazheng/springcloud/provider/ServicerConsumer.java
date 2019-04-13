package cn.njyazheng.springcloud.provider;

import cn.njyazheng.springcloud.domain.User;
import cn.njyazheng.springcloud.feign.CustomFeign;
import cn.njyazheng.springcloud.feign.ProviderFeign;
import cn.njyazheng.springcloud.feign.UrlFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicerConsumer {
//    @Autowired
//    private CustomFeign customFeign;

    @Autowired
    private ProviderFeign providerFeign;
    @Autowired
    private UrlFeign urlFeign;

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

}

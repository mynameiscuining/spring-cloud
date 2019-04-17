package cn.njyazheng.springcloud.feign;

import cn.njyazheng.springcloud.config.DisableHystrixWithSingleFeginConfig;
import cn.njyazheng.springcloud.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider-3",configuration = DisableHystrixWithSingleFeginConfig.class)
public interface DisableHystrixWithSingleFeign {

    @GetMapping("/get/name/{id}")
     //此处@PathVariable必须加value
    String getName(@PathVariable("id") String id);

    @GetMapping("/user")
    //get 方式不支持 @RequestBody User user
    //User getUser(@RequestBody User user);会报status405
    //多参数必须声明@RequestParam并加vaue
    User getUser(@RequestParam("id") Integer id, @RequestParam("name") String name);

}

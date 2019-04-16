package cn.njyazheng.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//这个地方的如果url不为空的话,name只是一个命名,将通过url进行调用
//若果这个地方为空,将认为name为是注册到eureka的实例
@FeignClient(name = "xxx",url = "http://localhost:7403")
public interface UrlFeign {
    @GetMapping("/get/name/{id}")
        //此处@PathVariable必须加value
    String getName(@PathVariable("id") String id);
}

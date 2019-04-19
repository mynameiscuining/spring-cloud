package cn.njyazheng.springcloud.feign;

import cn.njyazheng.springcloud.hystrix.ProviderFeign2FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-2",fallbackFactory = ProviderFeign2FallbackFactory.class)
public interface ProviderFeign2 {
    @GetMapping("/get/name/{id}")
        //此处@PathVariable必须加value
    String getName(@PathVariable("id") String id);
}

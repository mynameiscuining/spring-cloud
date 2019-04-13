package cn.njyazheng.springcloud.feign;

import cn.njyazheng.springcloud.config.CustomFeignConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
//引用自定义配置,因为configuration方式引用,CustomFeign就不需要再进行一次扫描了
//多个接口,name重名报错
//@FeignClient(name = "provider",configuration = CustomFeignConfig.class)
public interface CustomFeign {
//    @RequestLine("GET /get/name/{id}")
//    String contributors(@Param("id") String id);
}

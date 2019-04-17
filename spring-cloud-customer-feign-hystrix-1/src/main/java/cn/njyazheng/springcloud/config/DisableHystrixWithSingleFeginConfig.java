package cn.njyazheng.springcloud.config;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScanExclude
public class DisableHystrixWithSingleFeginConfig {
    //对单个feign禁用hystrix
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        //不支持hystrix
        return Feign.builder();
        //默认值返回值,支持hystrix
        //return HystrixFeign.builder();
    }
}

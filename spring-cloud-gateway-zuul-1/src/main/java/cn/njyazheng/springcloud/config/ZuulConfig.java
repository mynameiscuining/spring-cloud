package cn.njyazheng.springcloud.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//(5)
//访问规则配置,即如何以怎样的url代理微服务的url
//The preceding example means that a serviceId of myusers-v1 is mapped to route /v1/myusers/**
//如果不符合正则匹配,就会使用Zuul默认行为
public class ZuulConfig {
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper() {
//        //意思是把注册到eureka的appname-version映射成version/appname进行代理访问访问
//        //spring.application.name=appname-version
//        return new PatternServiceRouteMapper(
//                "(?<name>^.+)-(?<version>v.+$)",
//                "${version}/${name}");
//    }
}

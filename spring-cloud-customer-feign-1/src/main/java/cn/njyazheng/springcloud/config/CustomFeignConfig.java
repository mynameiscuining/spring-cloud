package cn.njyazheng.springcloud.config;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScanExclude
//为某一feign自定义配置
public class CustomFeignConfig {
    @Bean
    //契约默认使用的是SpringMvcContract,所以可以使用springmvc的注解
    //Default(),feign本身的注解 参考==>https://github.com/OpenFeign/feign
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    //到eureka server的认证, 配置优先,所以此处错误密码未执行
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}

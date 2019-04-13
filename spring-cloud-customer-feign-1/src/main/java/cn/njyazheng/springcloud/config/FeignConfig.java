package cn.njyazheng.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//全局feign配置
public class FeignConfig {
    @Bean
    //打印日志信息设置
    /**
     * NONE, 不打印日志
     * BASIC, Log only the request method and URL and the response status code and execution time.
     * HEADERS, Log the basic information along with request and response headers.
     * FULL, Log the headers, body, and metadata for both requests and responses.
     */
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

package cn.njyazheng.springcloud;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


/**
 * feign是一个声明式的web客户端
 * feign 整合了eureka和ribbon
 */
@SpringBootApplication
//开启feign
//If Hystrix is on the classpath and feign.hystrix.enabled=true,
// Feign will wrap all methods with a circuit breaker
@EnableFeignClients
@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ComponentScanExclude.class)})
public class ConsumerFeignHystrixApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignHystrixApplication1.class, args);
	}

}

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
 *重试默认是开启的
 * feign默认是通过自己包下的Retryer进行重试配置,默认是5次
 */
@SpringBootApplication
//开启feign
@EnableFeignClients
@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ComponentScanExclude.class)})
public class ConsumerFeignApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication1.class, args);
	}

}

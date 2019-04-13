package cn.njyazheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * feign是一个声明式的web客户端
 * feign 整合了eureka和ribbon
 */
@SpringBootApplication
//开启feign
@EnableFeignClients
public class ConsumerFeignApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication1.class, args);
	}

}

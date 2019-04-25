package cn.njyzheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//本项目是用于模拟非java语言开发的微服务项目
public class NonJVMApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonJVMApplication.class, args);
	}

}

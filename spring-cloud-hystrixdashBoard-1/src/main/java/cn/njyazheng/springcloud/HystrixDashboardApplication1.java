package cn.njyazheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//每一个要加入仪表盘的微服务必须加入如下依赖
//(1)spring-boot-starter-actuator(2)spring-cloud-starter-netflix-hystrix
//并且开启@EnableCircuitBreaker
//一定要有请求,仪表盘才会显示
//访问:/hystrix
@EnableHystrixDashboard
public class HystrixDashboardApplication1 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication1.class, args);
	}
}

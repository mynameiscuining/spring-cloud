package cn.njyazheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
/**
 *  Spring Cloud provides a spring-cloud-starter-netflix-turbine that has all
 *      the dependencies you need to get a Turbine server running. To add Turbine,
 *      create a Spring Boot application and annotate it with @EnableTurbine.
 */
//turbine.stream相对hystrix.stream是针对集群的
//开启Turbine
@EnableTurbine
public class HystrixTurbineApplication1 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication1.class, args);
	}
}

package cn.njyazheng.springcloud;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ComponentScanExclude.class)})
//启用断路器
@EnableCircuitBreaker
public class ConsumerRibbonHystrixApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonHystrixApplication2.class, args);
	}

}

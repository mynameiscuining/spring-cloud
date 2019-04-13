package cn.njyazheng.springcloud;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


/**
 * feign��һ������ʽ��web�ͻ���
 * feign ������eureka��ribbon
 */
@SpringBootApplication
//����feign
@EnableFeignClients
@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ComponentScanExclude.class)})
public class ConsumerFeignApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication1.class, args);
	}

}

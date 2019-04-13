package cn.njyazheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * feign��һ������ʽ��web�ͻ���
 * feign ������eureka��ribbon
 */
@SpringBootApplication
//����feign
@EnableFeignClients
public class ConsumerFeignApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication1.class, args);
	}

}

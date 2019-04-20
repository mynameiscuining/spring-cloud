package cn.njyazheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//All requests are executed in a hystrix command, so failures appear in Hystrix metrics
//通过本主机ip和端口+其他微服务的application.name(默认)/uri可以代理访问例子如下
//http://192.168.217.1:7413/provider(app)/user(uri)
@EnableZuulProxy
public class ZuulApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication1.class, args);
	}

}

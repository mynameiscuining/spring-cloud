package cn.njyzheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
//本项目是用于集成整合异构语言开发的微服务(非java语言开发的)
@EnableSidecar
//EnableSidecar会使这个配置eureka.instance.prefer-ip-address无效
//重要:其他微服务对异构的调用 为
// 1. ribbon: http://<sidecar(app.name)>/uri
//2. feign:  name=<sidecar(app.name)>
//3. zuul:代理: <sidecar(app.name)>/uri
public class SideCarApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(SideCarApplication1.class, args);
	}

}

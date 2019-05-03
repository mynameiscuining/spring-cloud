package cn.njyzheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication1.class, args);
	}

}

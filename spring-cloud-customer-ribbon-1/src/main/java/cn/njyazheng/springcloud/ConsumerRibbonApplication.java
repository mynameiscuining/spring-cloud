package cn.njyazheng.springcloud;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import cn.njyazheng.springcloud.config.CustomeAllRibbon;
import cn.njyazheng.springcloud.config.CustomeSingleRibbon;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//过滤注解ComponentScanExclude不扫描
//为虚拟IP provider定制包括负载策略等 ,但是@ComponentScan不能和本配置文件在同一级否则其他的虚拟IP也会变
//配置文件的优先级高于RibbonClient
//默认:ZoneAware 区域感知轮询负载均衡
//@RibbonClient(name = "provider", configuration = CustomeSingleRibbon.class)
//自定义配置所有ribbon
@RibbonClients(defaultConfiguration = CustomeAllRibbon.class)
@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ComponentScanExclude.class)})
public class ConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonApplication.class, args);
	}

}

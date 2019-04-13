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
//����ע��ComponentScanExclude��ɨ��
//Ϊ����IP provider���ư������ز��Ե� ,����@ComponentScan���ܺͱ������ļ���ͬһ����������������IPҲ���
//�����ļ������ȼ�����RibbonClient
//Ĭ��:ZoneAware �����֪��ѯ���ؾ���
//@RibbonClient(name = "provider", configuration = CustomeSingleRibbon.class)
//�Զ�����������ribbon
@RibbonClients(defaultConfiguration = CustomeAllRibbon.class)
@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ComponentScanExclude.class)})
public class ConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonApplication.class, args);
	}

}

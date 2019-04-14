package cn.njyazheng.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;

//过滤注解ComponentScanExclude不扫描
//为虚拟IP provider定制包括负载策略等 ,但是@ComponentScan不能和本配置文件在同一级否则其他的虚拟IP也会变
//配置文件的优先级高于RibbonClient
//默认:ZoneAware 区域感知轮询负载均衡
//@RibbonClient(name = "provider", configuration = CustomeSingleRibbon.class)
//自定义配置所有ribbon
@RibbonClients(defaultConfiguration = CustomeAllRibbon.class)
public class CustomRibbonConfig {
}

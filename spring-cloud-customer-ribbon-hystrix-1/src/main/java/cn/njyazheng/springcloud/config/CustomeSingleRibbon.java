package cn.njyazheng.springcloud.config;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//为虚拟IP provider定制包括负载策略等 ,但是@ComponentScan不能和本配置文件在同一级否则其他的虚拟IP也会变
//配置文件的优先级高于RibbonClient
//默认:ZoneAware 区域感知轮询负载均衡
/**
 * RoundRobinRule：通过简单的轮询服务列表来选择服务器，其他的规则在很多情况下，仍然使用RoundRobinRule。
 *
 *  AvailabilityFilteringRule：该规则会忽略以下服务器：
 *
 *      一、 无法连接的服务器：在默认情况下，如果3次连接失败，该服务器将会被置为“短路”的状态，该状态将持续30秒，如果再次连接失败，“短路”状态的持续时间将会以几何级增加。可以通过修改niws.loadbalancer.<clientName>.connectionFailureCountThreshold属性，来配置连接失败的次数。
 *
 *      二、并发数过高的服务器：如果连接到该服务器的并发数过高，也会被这个规则忽略，可以通过修改<clientName>.ribbon.ActiveConnectionsLimit属性来设定最高并发数。
 * WeightedResponseTimeRule：为每个服务器赋予一个权重值，服务器的响应时间越长，该权重值就是越少，这个规则会随机选择服务器，这个权重值有可能会决定服务器的选择。
 *
 * ZoneAvoidanceRule：该规则以区域、可用服务器为基础，进行服务器选择。使用Zone对服务器进行分类，可以理解为机架或者机房。
 *
 *  BestAvailableRule：忽略“短路”的服务器，并选择并发数较低的服务器。
 *
 *  RandomRule：顾名思义，随机选择可用的服务器。
 *
 *  RetryRule：含有重试的选择逻辑，如果使用RoundRobinRule选择服务器无法连接，那么将会重新选择服务器。
 */
@ComponentScanExclude
public class CustomeSingleRibbon {
    //定制负载随机策略
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}

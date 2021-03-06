**_学习笔记_**
===

雪崩效应
===
在微服务架构中通常会有多个服务层调用，大量的微服务通过网络进行通信，从而支撑起整个系统。  
各个微服务之间也难免存在大量的依赖关系。然而任何服务都不是100%可用的，网络往往也是脆弱  
的，所以难免有些请求会失败。基础服务的故障导致级联故障，进而造成了整个系统的不可用，这  
种现象被称为服务雪崩效应。服务雪崩效应描述的是一种因服务提供者的不可用导致服务消费者的  
不可用，并将不可用逐渐放大的过程。  
A作为服务提供者，B为A的服务消费者，C和D是B的服务消费者。A不可用引起了B的不可用，并将不  
可用像滚雪球一样放大到C和D时，雪崩效应就形成了。  
**解决方案**    
1.超时机制  
通过网络请求其他服务时，都必须设置超时。正常情况下，一个远程调用一般在几十毫秒内就返回了。  
当依赖的服务不可用，或者因为网络问题，响应时间将会变得很长（几十秒）。而通常情况下，一次  
远程调用对应了一个线程/进程，如果响应太慢，那这个线程/进程就会得不到释放。而线程/进程都对  
应了系统资源，如果大量的线程/进程得不到释放，并且越积越多，服务资源就会被耗尽，从而导致资  
深服务不可用。所以必须为每个请求设置超时。  
2.断路器模式  
当依赖的服务有大量超时时，再让新的请求去访问已经没有太大意义，只会无谓的消耗现有资源。譬  
如我们设置了超时时间为1秒，如果短时间内有大量的请求（譬如50个）在1秒内都得不到响应，就往  
往意味着异常。此时就没有必要让更多的请求去访问这个依赖了，我们应该使用断路器避免资源浪费。  
  
断路器可以实现快速失败，如果它在一段时间内侦测到许多类似的错误（譬如超时），就会强迫其以  
后的多个调用快速失败，不再请求所依赖的服务，从而防止应用程序不断地尝试执行可能会失败的操  
作，这样应用程序可以继续执行而不用等待修正错误，或者浪费CPU时间去等待长时间的超时。断路  
器也可以使应用程序能够诊断错误是否已经修正，如果已经修正，应用程序会再次尝试调用操作。  
  
断路器模式就像是那些容易导致错误的操作的一种代理。这种代理能够记录最近调用发生错误的次数  
，然后决定使用允许操作继续，或者立即返回错误。  
  
(1) 监控 总共请求多少次，有多少次失败   假设失败率达倒10% 断路器打开  
(2) 断路器的状态  
(3) 分流  
(4) 自我修复（断路器状态的切换）


Zuul
===
**简要**  
Zuul is a JVM-based router and server-side load balancer from Netflix;  

The default Hystrix isolation pattern (ExecutionIsolationStrategy) for all   
routes is SEMAPHORE.  zuul.ribbonIsolationStrategy can be changed to THREAD   
if that isolation pattern is preferred.  

The Zuul starter does not include a discovery client, so, for routes based  
 on service IDs, you need to provide one of those on the classpath as well  
  (Eureka is one choice).   
 **内部重定向(外部重定向不可用)**  
 Rewriting the Location header
 If Zuul is fronting a web application, you may need to re-write the Location  
 header when the web application redirects through a HTTP status code of 3XX.  
 Otherwise, the browser redirects to the web application’s URL instead of the   
 Zuul URL. You can configure a LocationRewriteFilter Zuul filter to re-write   
 the Location header to the Zuul’s URL. It also adds back the stripped global   
 and route-specific prefixes. The following example adds a filter by using a   
Spring Configuration file:  
_import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;  
...  
@Configuration  
@EnableZuulProxy  
public class ZuulConfig {  
    @Bean  
    public LocationRewriteFilter locationRewriteFilter() {  
        return new LocationRewriteFilter();  
    }  
}_    
**设置支持跨域访问**  
Enabling Cross Origin Requests  
By default Zuul routes all Cross Origin requests (CORS) to the services. If you  
want instead Zuul to handle these requests it can be done by providing custom   
WebMvcConfigurer bean:  
_@Bean  
public WebMvcConfigurer corsConfigurer() {  
    return new WebMvcConfigurer() {  
        public void addCorsMappings(CorsRegistry registry) {  
            registry.addMapping("/path-1/**")  
                    .allowedOrigins("http://allowed-origin.com")  
                    .allowedMethods("GET", "POST");  
        }  
    };  
}_  
**zuul过滤器(具体实现参考spring cloud官方文档)**   
1.pre：此种过滤器在请求被路由之前执行，显然这种过滤器可以用来过滤请求（白黑名单）、安全验证等；  
2.routing：此种过滤器复制将请求路由到具体的微服务上；  
3.post：此种过滤器在请求被路由到微服务之后执行，可以用来统计用户行为、响应客户端等；  
4.error：如果上面三种过滤器发生了错误，则执行此过滤器  


eureka常用配置(配置的赋值为默认值)
===
#表明eureka客户端是否可用,设置为false时不会向eureka服务端注册  
eureka.client.enabled=true  
#表明eureka客户端是否向eureka服务端拉去注册表信心,一般单机eureka服务端设置为false,集群eureka服务端需要开启,eureka客户端需要开启  
eureka.client.fetch-registry=true  
#表明数据的传输都是经过压缩的,更详细参见feign项目的配置  
eureka.client.g-zip-content=true  
#eureka客户端是否向eureka服务端注册  
eureka.client.register-with-eureka=true  
#表示eureka client间隔多久去拉取服务注册信息，默认为30秒，对于api-gateway，如果要迅速获取服务注册状态，可以缩小该值，比如5秒  
eureka.client.registry-fetch-interval-seconds=30  
#eureka.client.service-url是一个map,以下defaultZone为key,是eureka可识别的,下面配置表示用于向eureka注册的地址  
eureka.client.service-url.defaultZone=  
#是否开启eureka服务端仪表盘  
eureka.dashboard.enabled=true  
#eureka服务端仪表盘地址  
eureka.dashboard.path=/  
#设置实例应用名称和 spring.application.name用法一样,appname填坑,appname才是原始的名称,例如整合swagger(springcloud和swagger有一定的冲突)用到  
eureka.instance.appname=unknown  
#表示心脏跳动的频率  
eureka.instance.lease-renewal-interval-in-seconds=30  
#表示eureka server至上一次收到client的心跳之后，等待下一次心跳的超时时间，在这个时间内若没收到下一次心跳，则将移除该instance。  
#如果该值太大，则很可能将流量转发过去的时候，该instance已经不存活了。  
#如果该值设置太小了，则instance则很可能因为临时的网络抖动而被摘除掉。  
#该值至少应该大于lease-renewal-interval-in-seconds  
eureka.instance.lease-expiration-duration-in-seconds=90  
#设置实例主机名称,如果用主机名注册设置eureka.instance.prefer-ip-address=false  
eureka.instance.hostname=  
#实例ID,默认是主机名+:+端口号  
eureka.instance.instance-id=  
#设置实例的IP,用途不大  
eureka.instance.ip-address=  
#metadata-map设置元数据,将信息传送给eureka服务器,是一个map,以下设置zone为map的key,eureka可以识别,以下配置表示设置zone的名称  
eureka.instance.metadata-map.zone  
#eureka客户端设置是否用IP进行注册  
eureka.instance.prefer-ip-address=false  
#没用的配置  
eureka.instance.namespace=eureka  
#是否开启非https的端口  
eureka.instance.non-secure-port-enabled=true  
#非https的端口即http端口  
eureka.instance.non-secure-port=80  
#https的端口  
eureka.instance.secure-port=443  
#设置https健康检查的url  
eureka.instance.secure-health-check-url=  
#是否开启https端口  
eureka.instance.secure-port-enabled=false  
#设置使用https的虚拟的主机名  
eureka.instance.secure-virtual-host-name=unknown  
#设置使用http的虚拟的主机名  
eureka.instance.virtual-host-name=unknown  
#集群对等体状态刷新的时间,单位毫秒  
eureka.server.peer-eureka-status-refresh-time-interval-ms=0 
#开启自我保护  
eureka.server.enable-self-preservation=true  
#设置为true开启请求压缩。  
feign.compression.request.enabled=false  
#设置为true开户响应压缩。  
feign.compression.response.enabled=false  
#支持压缩的类型列表  
feign.compression.request.mime-type=text/xml,application/xml,application/json  
#设置请求内容的最小阀值，默认值为2048,配置压缩数据大小的下限  
feign.compression.request.min-request-size=2048  
#eureka server环境配置自定义(prod or dev),可在eureka server仪表盘显示   
eureka.environment=test  
#eureka server配置datacenter,可在eureka server仪表盘显示    
eureka.datacenter=default    

  
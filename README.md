**雪崩效应**
===
在微服务架构中通常会有多个服务层调用，大量的微服务通过网络进行通信，从而支撑起整个系统。  
各个微服务之间也难免存在大量的依赖关系。然而任何服务都不是100%可用的，网络往往也是脆弱  
的，所以难免有些请求会失败。基础服务的故障导致级联故障，进而造成了整个系统的不可用，这  
种现象被称为服务雪崩效应。服务雪崩效应描述的是一种因服务提供者的不可用导致服务消费者的  
不可用，并将不可用逐渐放大的过程。
A作为服务提供者，B为A的服务消费者，C和D是B的服务消费者。A不可用引起了B的不可用，并将不  
可用像滚雪球一样放大到C和D时，雪崩效应就形成了。  

**eureka常用配置(配置的赋值为默认值)**
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
#eureka server环境配置自定义,可在eureka server仪表盘显示  
eureka.environment=prod or dev  
#eureka server配置datacenter,可在eureka server仪表盘显示  
eureka.datacenter=default  

  
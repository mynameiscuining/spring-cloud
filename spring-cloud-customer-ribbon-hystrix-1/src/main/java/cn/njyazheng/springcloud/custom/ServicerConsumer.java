package cn.njyazheng.springcloud.custom;

import cn.njyazheng.springcloud.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
public class ServicerConsumer {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;
    //使用虚拟IP
    @GetMapping("/get/name/{id}")
    //对方法加断路器
    @HystrixCommand(fallbackMethod = "getNameFallbackMethod")
    public String getName(@PathVariable String id){
        return restTemplate.getForObject("http://provider/get/name/"+1,String.class);
    }
    //方法的参数和返回值都要和 @HystrixCommand注解的方法一致
    //请求的微服务异常,将进入此方法
    public String getNameFallbackMethod(String id){
        return "this is Hystrix getNameFallbackMethod";
    }
    @GetMapping("/user")
    /**
     *可以为@HystrixCommand设置属性,execution.isolation.strategy隔离策略
     **/
     /**
      *默认是THREAD:在固定大小线程池中，以单独线程执行，并发请求数受限于线程池大小。getUser和getUserFallbackMethod是两个隔离的线程
      **/
    /**
     * SEMAPHORE:在调用线程中执行，通过信号量来限制并发量.getUser和getUserFallbackMethod同属一个线程
     * The same thing applies if you are using @SessionScope or @RequestScope. If you encounter a runtime exception that says it
     *  cannot find the scoped context, you need to use the same thread.遇到这种问题就需要配置SEMAPHORE并设置上下文作用域,不出问题一般不需要配置
     *
     */
    @HystrixCommand(fallbackMethod = "getUserFallbackMethod",commandProperties = {@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
    public User getUser(){
        return restTemplate.getForObject("http://provider/user?id=1&name=cn",User.class);
    }
    //方法的参数和返回值都要和 @HystrixCommand注解的方法一致
    //请求的微服务异常,将进入此方法
    public User getUserFallbackMethod(){
        return new User(3,"SSS");
    }
}

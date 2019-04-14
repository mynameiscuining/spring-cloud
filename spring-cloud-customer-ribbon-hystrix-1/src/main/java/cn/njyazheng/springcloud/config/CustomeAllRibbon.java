package cn.njyazheng.springcloud.config;

import cn.njyazheng.springcloud.annomotions.ComponentScanExclude;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScanExclude
//参考文档目前,测试以下三项可用,其他的配置待查资料解决
public class CustomeAllRibbon {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
    //实例检查策略
    //默认采用NoOpPing 不检查都返回true
    //PingConstant 根据实例检查
    /**PingUrl
     * public PingUrl(boolean isSecure, String pingAppendString) {
     *         this.isSecure = isSecure;
     *         this.pingAppendString = pingAppendString != null ? pingAppendString : "";
     *   }
     *   微服务提供者http://localhost:port/pingAppendString 是可查询的才行返回200状态码
     *   或者不加pingAppendString请求http://localhost:port返回200状态码
     *isSecure false ==http
     * isSecure true ==https
     * */
    @Bean
    public IPing ribbonPing() {
        //根据url检查
        return new PingConstant();
    }

    @Bean
    public ServerListSubsetFilter serverListFilter() {
        ServerListSubsetFilter filter = new ServerListSubsetFilter();
        return filter;
    }

}

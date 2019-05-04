package cn.njyzheng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//用作刷新配置属性,手动刷新访问http://localhost:7418/actuator/refresh 访问method为post
@RefreshScope
/**
 * For a Spring Boot Actuator application, some additional management endpoints are available. You can use:
 * POST to /actuator/env to update the Environment and rebind @ConfigurationProperties and log levels.
 * /actuator/refresh to re-load the boot strap context and refresh the @RefreshScope beans.
 * /actuator/restart to close the ApplicationContext and restart it (disabled by default).
 * /actuator/pause and /actuator/resume for calling the Lifecycle methods (stop() and start() on the ApplicationContext).
 */
public class ConfigClientController {
    @Value("${name}")
    private String name;
    @RequestMapping("test")
    public String test(){
        return name;
    }
}

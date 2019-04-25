package cn.njyzheng.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//The non-JVM application should implement a health check so the Sidecar can report to Eureka whether the app is up or down.
public class NonJVMController {
    @RequestMapping("/actuator/health")
    public Map<String,Object> health(){
        Map<String,Object>map=new HashMap<>();
        map.put("status","UP");
        return map;
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}

package cn.njyzheng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${name}")
    private String name;
    @RequestMapping("test")
    public String test(){
        return name;
    }
}

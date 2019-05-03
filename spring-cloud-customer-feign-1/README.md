**一、简介**  
在微服务的架构下，我们需要把系统的业务划分成多个单一的微服务。每个微服务都会提供接  
口供其他微服务调用，在Dubbo中可以通过rmi、nio等实现，Spring Cloud中是通过http调  
用的。但有些时候，我们只希望用户通过我们的网关调用微服务，不允许用户直接请求微服务。  
这时我们就可以借助Spring Security来保障安全。  

**二、使用步骤**  
2.1 在提供接口的微服务项目中配置Spring Security  
1 首先在pom.xml引入Spring Security的相关配置，如下  

        <dependency>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-security</artifactId>  
        </dependency>  

2 在qpplication.yml中配置账号密码，如下  

security:  
  basic:  
    enabled: true  
  user:  
    name: sunbufu  
    password: 123456  

3 此时访问接口发现已经需要认证了。   
 
输入正确的账号和密码后就可以访问了。  

2.2在调用微服务项目中配置Feign的账号密码  
1 在application.yml中配置账号密码  

security:  
  user:  
    name: sunbufu  
    password: 123456  

2 添加Feign的配置文件  

package com.sunbufu.config;  

_import org.springframework.beans.factory.annotation.Value;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  

import feign.auth.BasicAuthRequestInterceptor;_  

_@Configuration  
public class FeignConfiguration {    

    @Value("${security.user.name}")  
    private String userName;  

    @Value("${security.user.password}")  
    private String passWord;  

    @Bean  
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){  
        return new BasicAuthRequestInterceptor(userName, passWord);  
    }_  

3 这样完成后，就可以正常的访问了。  

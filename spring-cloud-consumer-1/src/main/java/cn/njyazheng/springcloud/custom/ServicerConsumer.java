package cn.njyazheng.springcloud.custom;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ServicerConsumer {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${provider.get.name}")
    private  String url;
    //EurekaClient不能使用在注解 @PostConstruct method or in a @Scheduled method
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/get/name/{id}")
    public String getName(@PathVariable String id){
        return restTemplate.getForObject(url+1,String.class);
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam(value = "file",required = true) MultipartFile multipartFile) throws IOException {
        byte[] bytes=multipartFile.getBytes();
        File file=new File(multipartFile.getOriginalFilename());
        FileCopyUtils.copy(bytes,file);
        return file.getAbsolutePath();
    }
}

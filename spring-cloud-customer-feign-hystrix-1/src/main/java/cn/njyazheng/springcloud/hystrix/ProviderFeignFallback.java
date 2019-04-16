package cn.njyazheng.springcloud.hystrix;

import cn.njyazheng.springcloud.domain.User;
import cn.njyazheng.springcloud.feign.ProviderFeign;
import org.springframework.stereotype.Component;

// You also need to declare your implementation as a Spring bean.
@Component
public class ProviderFeignFallback implements ProviderFeign {
    @Override
    public String getName(String id) {
        return "ProviderFeignFallback--getName";
    }

    @Override
    public User getUser(Integer id, String name) {
        return new User(3,"ProviderFeignFallback--getUser");
    }
}

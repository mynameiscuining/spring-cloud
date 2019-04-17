package cn.njyazheng.springcloud.hystrix;

import cn.njyazheng.springcloud.domain.User;
import cn.njyazheng.springcloud.feign.DisableHystrixWithSingleFeign;
import org.springframework.stereotype.Component;

@Component
public class DisableHystrixWithSingleFeignFallbcack implements DisableHystrixWithSingleFeign {
    @Override
    public String getName(String id) {
        return "getName DisableHystrixWithSingleFeignFallbcack";
    }

    @Override
    public User getUser(Integer id, String name) {
        return new User(4,"getUser DisableHystrixWithSingleFeignFallbcack");
    }
}

package cn.njyazheng.springcloud.hystrix;

import cn.njyazheng.springcloud.feign.ProviderFeign2;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderFeign2FallbackFactory implements FallbackFactory<ProviderFeign2> {

    @Override
    public ProviderFeign2 create(Throwable throwable) {
        return new ProviderFeign2() {
            @Override
            public String getName(String id) {
                return throwable.toString();
            }
        };
    }
}

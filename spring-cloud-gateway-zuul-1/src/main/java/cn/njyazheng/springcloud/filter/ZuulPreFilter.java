package cn.njyazheng.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 1.pre：此种过滤器在请求被路由之前执行，显然这种过滤器可以用来过滤请求（白黑名单）、安全验证等；
 * 2.routing：此种过滤器复制将请求路由到具体的微服务上；
 * 3.post：此种过滤器在请求被路由到微服务之后执行，可以用来统计用户行为、响应客户端等；
 * 4.error：如果上面三种过滤器发生了错误，则执行此过滤器
 */
public class ZuulPreFilter extends ZuulFilter {

    //设置pre的类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //执行的顺序,数字越大越靠后
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //是否开启本过滤器
       // return false;
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FilterConstants.FORWARD_TO_KEY) // a filter has already forwarded
                && !ctx.containsKey(FilterConstants.SERVICE_ID_KEY); // a filter has already determined serviceId
    }

    //过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getParameter("sample") != null) {
            // put the serviceId in `RequestContext`
            ctx.put(FilterConstants.SERVICE_ID_KEY, request.getParameter("foo"));
        }
        return null;
    }
}

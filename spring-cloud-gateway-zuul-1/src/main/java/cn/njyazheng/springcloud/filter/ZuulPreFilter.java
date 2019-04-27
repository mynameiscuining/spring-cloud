package cn.njyazheng.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;


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

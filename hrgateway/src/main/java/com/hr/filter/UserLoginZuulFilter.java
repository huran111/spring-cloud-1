package com.hr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author 胡冉
 * @ClassName ZuulFilter
 * @Description: TODO
 * @Date 2019/5/6 17:22
 * @Version 2.0
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * // 设置执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String token = requestContext.getRequest().getParameter("token");
        if (StringUtils.isEmpty(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return  null;
        }
        return null;
    }

}

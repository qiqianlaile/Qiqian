package com.qf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.qf.pojo.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 54110 on 2020/9/1.
 */
//验证用户是否登录 过滤器
@Component
public class LoginFiter extends ZuulFilter{

    private String LOGIN_URL = "/baoleme-user/login";

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter(){
        //拿到当前请求
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //从request请求中获取请求的路径
        String requestURI = request.getRequestURI();
        if (requestURI.equals(LOGIN_URL)){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //从cookes中获取设置到前台的token，再使用token从redis中获取，获取成功 说明用户以登录，失败，说明用户未登录
        Cookie[] cookies =request.getCookies();
        String token = getToken(cookies);

        if (token!=null&&redisTemplate.hasKey(token)){
            return null;
        }
        //终止路由
        currentContext.setSendZuulResponse(false);
        //返回前端数据
        BaseResp baseResp = new BaseResp();
        baseResp.setMessage("用户未登录");
        currentContext.setResponseBody(baseResp.toString());
        HttpServletResponse response = currentContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        currentContext.setResponse(response);
        return null;
    }

    public String getToken(Cookie [] cookies){
        if (cookies!=null){
            for (Cookie cook:cookies
                 ) {
                if (cook.getName().equals("token")){
                    String token = cook.getValue();
                    return token;
                }
            }
            return null;
        }
        return null;
    }
}

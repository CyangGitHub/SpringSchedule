package com.example.module;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * Created by admin on 2016/12/18.
 */
@Configuration
@WebFilter(filterName = "Myfilter",urlPatterns = "/test/notify")
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*编码过滤*/

        servletRequest.setCharacterEncoding("GBK");

/*        Object sign = servletRequest.getAttribute("sign");
        System.out.println(sign);
*//*        System.out.println("字符编码:"+characterEncoding);
        System.out.println("gbk sign: "+sign);
        System.out.println("utf8 sign:"+new String(sign.getBytes("GBK"),"UTF-8"));*/

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }




}

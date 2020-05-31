package com.etoak.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * 支持同步请求发送rest请求的过滤器
 * 作用：将post请求转成PUT或者DELETE请求
 * 要求表单提交方式必须是POST
 * 表单必须有一个隐藏域，name属性值是_method， value属性值是rest请求方式
 */
@Configuration
public class RestFilterConfig {
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> restFilter() {


        FilterRegistrationBean<HiddenHttpMethodFilter> restFilter =
                new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        restFilter.addUrlPatterns("/*");
        return restFilter;

    }
}

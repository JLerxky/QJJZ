package com.jler.qjjz.until;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new Interceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/404");
        addInterceptor.excludePathPatterns("/login**");
        addInterceptor.excludePathPatterns("/joinIn");
        addInterceptor.excludePathPatterns("/check**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");

        super.addInterceptors(registry);
    }

}

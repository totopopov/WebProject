package org.softuni.timeTracker.config;

import org.softuni.timeTracker.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 11:41.
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final LogInterceptor logInterceptor;

    @Autowired
    public WebMvcConfiguration(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.logInterceptor);
    }
}

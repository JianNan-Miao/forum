package com.cheer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// TODO
@Configuration
public class SpringMvcConfigurationInitializer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/avatar/**").addResourceLocations("file:/avatar/");
        //file:/avatar/指向本地图片路径地址
         super.addResourceHandlers(registry);
    }
}

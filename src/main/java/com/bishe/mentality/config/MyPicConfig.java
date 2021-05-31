package com.bishe.mentality.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir")+"/src/main/resources/static/assets/images/actPhoto/";
        //       /images/**是对应resource下工程目录
//        registry.addResourceHandler("/images/**").addResourceLocations("file:"+path);
        registry.addResourceHandler("/assets/images/actPhoto/**")
                .addResourceLocations("file:"+path);
    }
}

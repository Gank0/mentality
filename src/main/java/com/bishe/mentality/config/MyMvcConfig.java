package com.bishe.mentality.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@Configuration
//public class MyMvcConfig extends WebMvcConfigurerAdapter {
//
////    @Override
////    public void addViewControllers(ViewControllerRegistry registry){
////
////
////    }
//
//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index.html").setViewName("index");
//                registry.addViewController("/sss").setViewName("login");
//            }
//        };
//        return adapter;
//    }
//}


//import com.bishe.mentality.handle.LoginHandlerInterceptor;
import com.bishe.mentality.handle.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{



    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index","/","/user/login","/static/**");   //不被拦截的请求
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

}

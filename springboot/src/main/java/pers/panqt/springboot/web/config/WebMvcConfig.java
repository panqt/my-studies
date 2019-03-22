package pers.panqt.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.panqt.springboot.web.interceptor.CustomInterceptor;

/**
 *  @time       2019年02月03日	13:35
 *	@author     panqt
 *
 *	@comment    速度
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor).addPathPatterns("*").excludePathPatterns("/login");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
        registry.addStatusController("/404",HttpStatus.NOT_FOUND);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowCredentials(false)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedOrigins("*")
                .maxAge(1800);
    }
}

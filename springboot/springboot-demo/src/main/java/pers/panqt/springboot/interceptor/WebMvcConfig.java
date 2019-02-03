package pers.panqt.springboot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  @time       2019年02月03日	13:35
 *	@author     panqt
 *
 *	@comment    
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor).addPathPatterns("/interceptor-test");
    }
}

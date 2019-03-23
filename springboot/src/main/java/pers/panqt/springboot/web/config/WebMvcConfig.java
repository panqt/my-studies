package pers.panqt.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.panqt.springboot.web.interceptor.CustomInterceptor;
import pers.panqt.springboot.web.interceptor.SessionInterceptor;

/**
 *  @time       2019年02月03日	13:35
 *	@author     panqt
 *
 *	@comment    速度
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private CustomInterceptor customInterceptor;

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor).addPathPatterns("/*");
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/login",
                "/auth",
                "/",
                "/welcome",
                "/css/**",
                "/js/**",
                "/img/**"
        );
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
        registry.addStatusController("/404",HttpStatus.NOT_FOUND);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                //是否允许发送Cookie。 AJAX参数：withCredentials = true;
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedOrigins("*")
                .maxAge(1800);
    }
}

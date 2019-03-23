package pers.panqt.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
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
        registry.addInterceptor(customInterceptor).addPathPatterns("/**");
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

    /**
     * 特别注意：是把前面的路径绑定到 后面的 视图。把 / 定向到 welcome
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/error").setViewName("404");
    }

    /**
     * 拦截器在这个方法之前执行，这么配置跨域没有效果，使用下面的 Bean 注入过滤器
     * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //是否允许发送Cookie，ajax参数：withCredentials = true;
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH","OPTIONS","HEAD")
                .allowedOrigins("*")
                .maxAge(1800);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}

package pers.panqt.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.panqt.springboot.web.interceptor.SessionInterceptor;
import pers.panqt.springboot.web.interceptor.SessionInterceptor2;

import javax.servlet.http.HttpServletResponse;

/**
 *  @time       2019年02月03日	13:35
 *	@author     panqt
 *
 *	@comment    速度
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private SessionInterceptor sessionInterceptor;
    @Autowired
    private SessionInterceptor2 sessionInterceptor2;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/",
                "/auth",
                "/captcha",
                "/css/**",
                "/js/**",
                "/img/**",

                "/welcome",
                "/modules/login",
                "/template",
                "/modules/fastdfs",
                "/modules/mail",
                "/modules/redis",
                "/modules/elasticsearch",
                "/modules/rabbitmq",
                "/modules/ajax"

        );

        registry.addInterceptor(sessionInterceptor2).addPathPatterns("/**").excludePathPatterns(
                "/",
                "/auth",
                "/captcha",
                "/css/**",
                "/js/**",
                "/img/**",

                "/welcome",
                "/modules/login"
        );
    }

    /**
     * 特别注意：是把前面的 mapping 绑定到后面的 view
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
    }

    /**<a>http://www.ruanyifeng.com/blog/2016/04/cors.html</a>
     * <a>https://segmentfault.com/a/1190000012550346</a>
     * 拦截器会在跨域响应设置之前执行，如果拦截器不放行，就不能返回跨域参数，客户端就不能发起跨域，使用下面的 Bean 注入过滤器
     *
     * 非简单请求： 如果要使这个跨域配置生效，在 拦截器 中放行 OPTIONS 请求,因为非简单请求会
     *             在请求之前 发送 OPTIONS 请求，拦截器放行后，设置跨域参数，客户端会获得跨域资格
     * 简单请求：   拦截器放行 OPTIONS 请求也没有效果，因为 简单请求，浏览器不发送 OPTIONS请求，
     *             而是直接发送 GET POST 请求，被拦截,不能设置跨域参数，依然会出跨域问题
     *
     * 也可以直接在拦截器的 response 中设置跨域
     *                      response.setHeader("Access-Control-Allow-Credentials", "true");
     *                      response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,PATCH,OPTIONS,HEAD");
     *                      response.setHeader("Access-Control-Allow-Origin", "*");
     *                      response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization");
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

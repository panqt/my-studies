package pers.panqt.springcloudzuul7000;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@EnableZuulProxy
@SpringBootApplication
public class Zuul7000 {

    @Bean
    public IRule iRule(){
        return new WeightedResponseTimeRule();
    }

    //@Bean
    //public ErrorAttributes defaultErrorAttributes(){
    //    return new DefaultErrorAttributes() {
    //        @Override
    //        public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    //            Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
    //            map.remove("excption");
    //            return map;
    //        }
    //    };
    //}

    public static void main(String[] args) {
        SpringApplication.run(Zuul7000.class, args);
    }

}

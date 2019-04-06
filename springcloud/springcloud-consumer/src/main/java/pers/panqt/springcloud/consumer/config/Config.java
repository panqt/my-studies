package pers.panqt.springcloud.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**  @author panqt 2019/04/07 5:06
 *   
 */
@Slf4j
@Configuration
public class Config {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

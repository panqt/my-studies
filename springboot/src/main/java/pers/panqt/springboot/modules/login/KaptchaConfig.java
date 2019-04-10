package pers.panqt.springboot.modules.login;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**  @author panqt 2019/04/10 20:20
 *   
 */
@Slf4j
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        //properties.load(this.getClass().getClassLoader().getResourceAsStream("bootstrap.properties"));
        properties.setProperty("kaptcha.border", "no");
        properties.setProperty("kaptcha.textproducer.char.space", "10");
        properties.setProperty("kaptcha.textproducer.font.color", "BLACK");
        properties.setProperty("kaptcha.image.width", "156");
        properties.setProperty("kaptcha.image.height", "66");
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}

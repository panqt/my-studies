package pers.panqt.springboot.modules.login;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.panqt.springboot.modules.redis.RedisService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**  @author panqt 2019/04/10 20:31
 *   
 */
@Slf4j
@Service
public class CaptchaService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    public String createCaptcha(HttpServletRequest request)throws Exception{
        String captchaRedisKey = "captcha-redis-key-"+request.getRequestedSessionId();

        String captcha = this.defaultKaptcha.createText();
        redisService.setValue(captchaRedisKey, captcha.toLowerCase(), 60*1000);

        BufferedImage bi = this.defaultKaptcha.createImage(captcha);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", baos);
        String base64 = "data:image/png;base64,"+Base64.getEncoder().encodeToString(baos.toByteArray());
        baos.close();
        log.debug("创建验证码，SessionId: [{}], 验证码: [{}]", request.getRequestedSessionId(), captcha);
        return base64;
    }

    public boolean checkCaptcha(HttpServletRequest request,String captcha){
        String captchaRedisKey = "captcha-redis-key-"+request.getRequestedSessionId();

        if(captcha.toLowerCase().equals(redisService.getValue(captchaRedisKey))){
            return true;
        }
        return false;
    }
}

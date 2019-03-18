package pers.panqt.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @time       2019年02月02日	21:41
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class MailController {

    @Autowired
    JavaMailSenderImpl mailSender;

    @GetMapping("send-mail")
    public String sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Hello World");
        message.setText("text");

        message.setTo("pqt680507@163.com");
        message.setFrom("1255457995@qq.com");

        mailSender.send(message);

        return "";
    }
}

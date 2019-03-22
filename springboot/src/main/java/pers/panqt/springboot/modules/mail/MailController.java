package pers.panqt.springboot.modules.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.entry.MailMessage;

/**  @auther panqt 2019/2/02 21:41
 */
@RestController
@RequestMapping("modules")
public class MailController {

    @Autowired
    JavaMailSenderImpl mailSender;

    @PostMapping("send-mail")
    public ResultVo sendMail(@RequestBody MailMessage mailMessage){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(mailMessage.getTitil());
        message.setText(mailMessage.getText());

        message.setTo(mailMessage.getTarget());
        message.setFrom("1255457995@qq.com");

        mailSender.send(message);

        return new ResultVo("发送成功");
    }
}

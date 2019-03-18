package pers.panqt.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @time       2019年02月02日	21:56
 *	@author     panqt
 *
 *	@see    pers.panqt.springboot.SpringbootDemoApplication
 *          加注解 @EnableScheduling
 */
@Service
public class ScheduledService {
    // 表示周一到周六当秒为0时执行一次
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void Scheduled() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        System.out.println(date + "定时调度： Scheduled hello....");
    }
}

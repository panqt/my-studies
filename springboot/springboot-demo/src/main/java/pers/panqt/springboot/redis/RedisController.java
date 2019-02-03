package pers.panqt.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.mybatis.UserMapper;

/**
 *  @time       2019年02月02日	10:45
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("setRedis/{id}")
    public String setRedis(@PathVariable("id") String id){
        User user = userMapper.findById(Integer.valueOf(id));
        redisService.setValue(id,user);
        return "";
    }

    @GetMapping("getRedis/{id}")
    public Object getRedis(@PathVariable("id") String id){
        return redisService.getValue(id);
    }
}

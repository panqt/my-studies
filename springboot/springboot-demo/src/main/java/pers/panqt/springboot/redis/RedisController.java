package pers.panqt.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.mybatis.UserMapper;

/**
 *  @time       2019年02月02日	10:45
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("set/{id}")
    public String set(@PathVariable("id") String id){
        User user = userMapper.selectById(Integer.valueOf(id));
        redisService.setValue(id,user);
        return "";
    }

    @GetMapping("get/{id}")
    public Object get(@PathVariable("id") String id){
        return redisService.getValue(id);
    }
}

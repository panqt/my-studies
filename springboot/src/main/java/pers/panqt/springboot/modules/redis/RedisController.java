package pers.panqt.springboot.modules.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.modules.mybatis.UserMapper;

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

    @PostMapping("set")
    public ResultVo<String> set(@RequestBody User user){
        redisService.setValue(user.getUserId()+"",user);
        return new ResultVo("缓存成功");
    }

    @PostMapping("get")
    public ResultVo<User> get(@RequestBody User user){
        return new ResultVo(redisService.getValue(user.getUserId()+""));
    }


}

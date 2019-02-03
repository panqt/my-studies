package pers.panqt.springboot.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.User;

/**
 *  @time       2019年02月01日	22:23
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class MybatisController {

    Logger logger = LoggerFactory.getLogger(MybatisController.class);

    @Autowired
    private UserMapper userMapper;

    @PostMapping("mybatis-insert")
    public void insert(@RequestBody User user){
        userMapper.insert(user);
    }

    @GetMapping("mybatis-find/{id}")
    public User find(@PathVariable("id") int id){
        User user = userMapper.findById(id);
        logger.debug("============> 查询{}",id);
        return user;
    }
}

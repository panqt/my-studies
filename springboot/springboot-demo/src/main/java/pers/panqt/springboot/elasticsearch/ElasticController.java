package pers.panqt.springboot.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.User;

import java.util.List;

/**
 *  @time       2019年02月02日	19:21
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
@RequestMapping("es")
public class ElasticController {

    @Autowired
    private ElasticRepository elasticRepository;



    @PostMapping("save")
    public Object save(@RequestBody User user){
        return elasticRepository.save(user);
    }

    @GetMapping("get/{userId}")
    public User get(@PathVariable("userId") int userId){
        return elasticRepository.findById(userId).get();
    }

    @GetMapping("getlike")
    public List<User> getlike(String userName){
        return elasticRepository.findByUserNameLike(userName);
    }
}

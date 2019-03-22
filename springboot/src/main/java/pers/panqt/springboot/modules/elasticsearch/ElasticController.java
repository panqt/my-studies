package pers.panqt.springboot.modules.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.entry.User;

import java.util.List;

/**
 *  @time       2019年02月02日	19:21
 *	@author     panqt
 *
 *	@see     {@link pers.panqt.springboot.SpringbootDemoApplication#main(String[])}
 */
@RestController
@RequestMapping("elasticsearch")
public class ElasticController {

    @Autowired
    private ElasticRepository elasticRepository;



    @PostMapping("save")
    public ResultVo<User> save(@RequestBody User user){
        return new ResultVo(elasticRepository.save(user));
    }

    @PostMapping("get")
    public ResultVo<User> get(@RequestBody User user){
        return new ResultVo(elasticRepository.findById(user.getUserId()).get());
    }

    @PostMapping("get-like")
    public ResultVo<List> getlike(@RequestBody User user){
        return new ResultVo(elasticRepository.findByUserNameLike(user.getUserName()));
    }
}

package pers.panqt.springboot.elasticsearch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.mybatis.UserMapper;

import java.util.Iterator;
import java.util.List;

/**
 *  @time       2019年03月18日	2:14
 *	@author     panqt
 *
 *	@comment    
 */
public class EsTest extends BaseTest {

    @Autowired
    ElasticRepository elasticRepository;

    @Autowired
    UserMapper userMapper;

    @Test
    public void save(){
        User user = userMapper.selectById(1);
        logger(user);
        user = elasticRepository.save(user);
        logger(user);
    }

    @Test
    public  void find(){
        Iterable<User> users= elasticRepository.findAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            logger(iterator.next());
        }
    }
}

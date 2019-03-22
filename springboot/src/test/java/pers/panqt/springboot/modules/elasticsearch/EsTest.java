package pers.panqt.springboot.modules.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.modules.mybatis.UserMapper;

import java.util.Iterator;

/**
 *  @time       2019年03月18日	2:14
 *	@author     panqt
 *
 *	@comment    
 */

@Slf4j
public class EsTest extends BaseTest {

    @Autowired
    ElasticRepository elasticRepository;

    @Autowired
    UserMapper userMapper;

    @Test
    public void save(){
        User user = userMapper.selectById(1);
        log.debug("[EsTest.save line 31]: {}",user);
        user = elasticRepository.save(user);
        log.debug("[EsTest.save line 31]: {}",user);
    }

    @Test
    public  void find(){
        Iterable<User> users= elasticRepository.findAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            log.debug("[EsTest.save line 31]: {}",iterator.next());
        }
    }




}

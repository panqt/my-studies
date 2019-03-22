package pers.panqt.springboot.modules.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.User;

import java.sql.Timestamp;

/**
 *  @time       2019年03月17日	18:23
 *	@author     panqt
 *
 *	@comment    
 */
@Slf4j
public class UserMapperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectById() {
        log.debug("[UserMapperTest.selectById line 23]: {}",
                userMapper.selectById(1));
    }

    @Test
    public void selectList() {
        User user = new User();
        user.setRoleId(4);
        user.setUserName("车车");
        log.debug("[UserMapperTest.selectList line 31]: {}",
                userMapper.selectList(user));
    }

    @Test
    public void insert() {
        User user = new User();
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setRoleId(3);
        user.setUserName("哈哈哈哈");
        user.setDepartmentId(5);
        log.debug("[UserMapperTest.insert line 42]: {}",
                userMapper.insert(user));
    }

    @Test
    public void update() {
        User user = new User();
        user.setUserId(7);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setRoleId(3);
        user.setUserName("呜呜呜");
        user.setDepartmentId(3);
        log.debug("[UserMapperTest.update line 54]: {}",
                userMapper.update(user));
    }

    @Test
    public void delete() {
        log.debug("[UserMapperTest.delete line 60]: {}",
                userMapper.delete(14));
    }


}

package pers.panqt.springboot.mybatis;

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
public class UserMapperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectById() {
        logger(userMapper.selectById(1));
    }

    @Test
    public void selectList() {
        User user = new User();
        user.setRoleId(4);
        user.setUserName("车车");
        logger(userMapper.selectList(user));
    }

    @Test
    public void insert() {
        User user = new User();
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setRoleId(3);
        user.setUserName("哈哈哈哈");
        user.setDepartmentId(5);
        logger(userMapper.insert(user));
    }

    @Test
    public void update() {
        User user = new User();
        user.setUserId(7);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setRoleId(3);
        user.setUserName("呜呜呜");
        user.setDepartmentId(3);
        logger(userMapper.update(user));
    }

    @Test
    public void delete() {
        logger(userMapper.delete(14));
    }


}

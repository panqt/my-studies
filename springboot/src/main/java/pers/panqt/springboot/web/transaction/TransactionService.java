package pers.panqt.springboot.web.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.modules.mybatis.UserMapper;
import pers.panqt.springboot.SpringbootDemoApplication;

import java.sql.Timestamp;

/**  @author panqt 2019/03/23 5:09
 *   @see {@link SpringbootDemoApplication} 注解
 */
@Slf4j
@Service
public class TransactionService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(){
        User user = new User();
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setRoleId(3);
        user.setUserName("哈哈哈哈ge");
        user.setDepartmentId(5);
        userMapper.insert(user);

        throw new RuntimeException();


    }
}

package pers.panqt.springcloud.provider.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.panqt.springcloud.entities.User;
import pers.panqt.springcloud.provider.service.UserService;
import pers.panqt.springcloud.provider.mapper.UserMapper;

import java.util.List;

/**  @author panqt 2019/04/07 4:45
 *   
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(int userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public List<User> list(User user) {
        return userMapper.selectList(user);
    }

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(int userId) {
        return userMapper.delete(userId);
    }
}

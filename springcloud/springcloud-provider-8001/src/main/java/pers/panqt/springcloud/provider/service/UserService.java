package pers.panqt.springcloud.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.panqt.springcloud.entities.User;
import pers.panqt.springcloud.provider.mapper.UserMapper;

import java.util.List;

/**  @author panqt 2019/04/07 4:44
 *   
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User get(int userId) {
        return userMapper.selectById(userId);
    }

    public List<User> list(User user) {
        return userMapper.selectList(user);
    }

    public int add(User user) {
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int delete(int userId) {
        return userMapper.delete(userId);
    }
}
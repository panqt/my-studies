package pers.panqt.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import pers.panqt.dubbo.provider.api.UserService;
import pers.panqt.dubbo.provider.entry.User;

/**
 *  @time       2019年02月03日	15:41
 *	@author     panqt
 *
 *	@comment    
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        System.out.println(String.format("=====> 提供者获得参数[%d]",id));
        return new User(id,10*id,"张三"+id);
    }
}

package pers.panqt.dubbo.provider.api;

import pers.panqt.dubbo.provider.entry.User;

/**
 *  @time       2019年02月03日	15:39
 *	@author     panqt
 *
 *	@comment
 */
public interface UserService {

    public User findById(int id);
}

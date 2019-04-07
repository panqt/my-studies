package pers.panqt.springcloud.provider.service;

import pers.panqt.springcloud.entities.User;

import java.util.List;

/**  @author panqt 2019/04/07 4:44
 *   
 */
public interface UserService {
    public User get(int userId);

    public List<User> list(User user);

    public int add(User user);

    public int update(User user);

    public int delete(int userId);
}

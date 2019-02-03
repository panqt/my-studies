package pers.panqt.springboot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import pers.panqt.springboot.entry.User;

/**
 *  @time       2019年02月01日	21:55
 *	@author     panqt
 *
 *	@comment    
 */
@Mapper
public interface UserMapper {

    public User findById(int userId);

    public void insert(User user);
}

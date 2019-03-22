package pers.panqt.springboot.modules.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.panqt.springboot.entry.User;

import java.util.List;

/**
 *  @time       2019年02月01日	21:55
 *	@author     panqt
 *
 *	@comment    
 */
@Mapper
@Repository
public interface UserMapper {

    public User selectById(int userId);

    public List<User> selectList(User user);

    public int insert(User user);

    public int update(User user);

    public int delete(int userId);
}

package pers.panqt.springboot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.panqt.springboot.entry.Role;

import java.util.List;

/**
 *  @time       2019年03月17日	17:37
 *	@author     panqt
 *
 *	@comment    
 */
@Mapper
@Repository
public interface RoleMapper {
    public Role selectById(int roleId);

    public List<Role> selectList(Role role);

    public int insert(Role role);

    public int update(Role role);

    public int delete(int roleId);
}

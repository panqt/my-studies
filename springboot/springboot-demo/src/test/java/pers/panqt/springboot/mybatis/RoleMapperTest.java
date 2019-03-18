package pers.panqt.springboot.mybatis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.Role;

import java.util.List;

/**
 *  @time       2019年03月17日	23:51
 *	@author     panqt
 *
 *	@comment    
 */
public class RoleMapperTest extends BaseTest {
    @Autowired
    RoleMapper roleMapper;

    @Test
    public void selectById(){
        logger(roleMapper.selectById(1));
    }

    @Test
    public void selectList(){
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("经理");
        logger(roleMapper.selectList(role));
    }

    @Test
    public void insert(){
        Role role =new Role();
        role.setRoleName("角色");
        logger(roleMapper.insert(role));
    }

    @Test
    public void update(){
        Role role =new Role();
        role.setRoleId(8);
        role.setRoleName("asdasd");
        logger(roleMapper.update(role));
    }

    @Test
    public void delete(){
        logger(roleMapper.delete(8));
    }
}

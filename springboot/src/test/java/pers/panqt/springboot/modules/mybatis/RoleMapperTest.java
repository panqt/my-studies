package pers.panqt.springboot.modules.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.Role;

/**
 *  @time       2019年03月17日	23:51
 *	@author     panqt
 *
 *	@comment    
 */
@Slf4j
public class RoleMapperTest extends BaseTest {
    @Autowired
    RoleMapper roleMapper;

    @Test
    public void selectById(){
        log.debug("[RoleMapperTest.selectById line 22]: {}",
                roleMapper.selectById(1));
    }

    @Test
    public void selectList(){
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("经理");
        log.debug("[RoleMapperTest.selectList line 31]: {}",
                roleMapper.selectList(role));
    }

    @Test
    public void insert(){
        Role role =new Role();
        role.setRoleName("角色");
        log.debug("[RoleMapperTest.insert line 39]: {}",
                roleMapper.insert(role));
    }

    @Test
    public void update(){
        Role role =new Role();
        role.setRoleId(8);
        role.setRoleName("asdasd");
        log.debug("[RoleMapperTest.update line 48]: {}",
                roleMapper.update(role));
    }

    @Test
    public void delete(){
        log.debug("[RoleMapperTest.delete line 54]: {}",
                roleMapper.delete(8));
    }
}

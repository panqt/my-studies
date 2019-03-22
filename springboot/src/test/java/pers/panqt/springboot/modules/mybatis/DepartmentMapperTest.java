package pers.panqt.springboot.modules.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.Department;

/**
 *  @time       2019年03月18日	0:11
 *	@author     panqt
 *
 *	@comment    
 */
@Slf4j
public class DepartmentMapperTest extends BaseTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void selectById(){
        log.debug("[DepartmentMapperTest.selectById line 21]: {}",
                departmentMapper.selectById(1));
    }

    @Test
    public void selectList(){
        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("销售部");
        log.debug("[DepartmentMapperTest.selectList line 30]: {}",
                departmentMapper.selectList(department));
    }

    @Test
    public void insert(){
        Department department =new Department();
        department.setDepartmentName("法务不");
        log.debug("[DepartmentMapperTest.insert line 38]: {}",
                departmentMapper.insert(department));
    }

    @Test
    public void update(){
        Department department =new Department();
        department.setDepartmentId(6);
        department.setDepartmentName("法务部");
        log.debug("[DepartmentMapperTest.update line 47]: {}",
                departmentMapper.update(department));
    }

    @Test
    public void delete(){
        log.debug("[DepartmentMapperTest.delete line 53]: {}",
                departmentMapper.delete(4));
    }
}

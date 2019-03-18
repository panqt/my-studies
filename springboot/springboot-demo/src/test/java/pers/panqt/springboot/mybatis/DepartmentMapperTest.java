package pers.panqt.springboot.mybatis;

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
public class DepartmentMapperTest extends BaseTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void selectById(){
        logger(departmentMapper.selectById(1));
    }

    @Test
    public void selectList(){
        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("销售部");
        logger(departmentMapper.selectList(department));
    }

    @Test
    public void insert(){
        Department department =new Department();
        department.setDepartmentName("法务不");
        logger(departmentMapper.insert(department));
    }

    @Test
    public void update(){
        Department department =new Department();
        department.setDepartmentId(6);
        department.setDepartmentName("法务部");
        logger(departmentMapper.update(department));
    }

    @Test
    public void delete(){
        logger(departmentMapper.delete(4));
    }
}

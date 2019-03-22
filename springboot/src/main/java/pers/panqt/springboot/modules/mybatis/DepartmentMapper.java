package pers.panqt.springboot.modules.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.panqt.springboot.entry.Department;

import java.util.List;

/**
 *  @time       2019年03月17日	17:38
 *	@author     panqt
 *
 *	@comment    
 */
@Mapper
@Repository
public interface DepartmentMapper {
    public Department selectById(int departmentId);

    public List<Department> selectList(Department department);

    public int insert(Department department);

    public int update(Department department);

    public int delete(int departmentId);
}

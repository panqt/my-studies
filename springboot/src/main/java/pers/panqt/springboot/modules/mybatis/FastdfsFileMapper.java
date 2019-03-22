package pers.panqt.springboot.modules.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.panqt.springboot.entry.FastdfsFile;
import java.util.List;

/**
 *  @time       2019年03月18日	4:22
 *	@author     panqt
 *
 *	@comment    
 */
@Mapper
@Repository
public interface FastdfsFileMapper {
    public int insert(String fileId);
    public int delete(String fileId);
    public String findById(String fileId);
    public List<FastdfsFile> findAll();
}

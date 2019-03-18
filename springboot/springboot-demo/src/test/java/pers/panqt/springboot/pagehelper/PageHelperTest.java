package pers.panqt.springboot.pagehelper;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.mybatis.UserMapper;

/**
 *  @time       2019年03月18日	1:40
 *	@author     panqt
 *
 *	@comment    
 */
public class PageHelperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void page(){
        PageHelper.startPage(4,5);
        logger(userMapper.selectList(new User()));
        logger(PageHelper.getLocalPage());
    }
}

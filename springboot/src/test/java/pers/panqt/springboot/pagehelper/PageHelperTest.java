package pers.panqt.springboot.pagehelper;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.panqt.springboot.BaseTest;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.modules.mybatis.UserMapper;

/**
 *  @time       2019年03月18日	1:40
 *	@author     panqt
 *
 *	@comment    
 */
@Slf4j
public class PageHelperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void page(){
        PageHelper.startPage(4,5);
        log.info("[PageHelperTest.page line 24]: {}",
                userMapper.selectList(new User()));
        log.info("[PageHelperTest.page line 26]: {}",
                PageHelper.getLocalPage());

    }
}

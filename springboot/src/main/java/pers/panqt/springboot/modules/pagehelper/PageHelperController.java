package pers.panqt.springboot.modules.pagehelper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.entry.User;
import pers.panqt.springboot.modules.mybatis.UserMapper;

import java.util.List;

/**  @author panqt 2019/04/04 22:39
 *   
 */
@Slf4j
@RestController
public class PageHelperController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("pagehelper")
    public void pagehelper(){
        PageHelper.startPage(4,5);

        List<User> users = userMapper.selectList(new User());

        Page page = PageHelper.getLocalPage();

    }
}


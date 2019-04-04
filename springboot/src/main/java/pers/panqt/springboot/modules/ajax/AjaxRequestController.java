package pers.panqt.springboot.modules.ajax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.ResultVo;
import pers.panqt.springboot.entry.User;

/**  @author panqt 2019/03/22 9:01
 *   测试 Ajax 请求
 */
@Slf4j
@RequestMapping("ajax")
@RestController
public class AjaxRequestController {

    /**  GET 方法不用 @RequestBody ,因为GET方法不带参数，参数在URL里，自动与对象参数绑定，不需要 @RequestBody 解析 JSON 字符串
     *
     *   {@link PathVariable} {@link RequestParam}
     *
     *   static/js/modules/ajax.js
     */
    @GetMapping("get/{id}")
    public ResultVo get(ResultVo resultVo, @PathVariable("id") String id, @Validated User user){
        resultVo.setData("get");
        return resultVo;
    }
    
    @PutMapping("put")
    public ResultVo<String> put(ResultVo<String> resultVo, @RequestBody @Validated User user){
        resultVo.setData("put");
        return resultVo;
    }

    @PostMapping("post")
    public ResultVo<String> post(ResultVo<String> resultVo, @RequestBody @Validated User user){
        resultVo.setData("post");
        return resultVo;
    }

    @DeleteMapping("delete/{id}")
    public ResultVo<String> delete(ResultVo<String> resultVo, @PathVariable("id") String id,@RequestBody @Validated User user){
        resultVo.setData("delete");
        return resultVo;
    }

    @DeleteMapping("delete-list")
    public ResultVo<String> deleteList(ResultVo<String> resultVo, @RequestBody String[] ids){
        for(String id : ids){
            System.out.println(id);
        }
        resultVo.setData("delete");
        return resultVo;
    }
}

package pers.panqt.springboot.web.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.panqt.springboot.entry.ResultVo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *  @time       2019年03月14日	23:24
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
@RequestMapping("session")
public class RedisSessionController {
    @GetMapping("/first")
    public ResultVo firstResp (HttpServletRequest request){
        System.out.println(request.getSession().getId());

        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return new ResultVo(map);
    }

    @GetMapping("get-session")
    public ResultVo getSession (HttpServletRequest request){
        System.out.println(request.getSession().getId());

        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", "上一次地址："+request.getSession().getAttribute("request Url"));
        return new ResultVo(map);
    }
}

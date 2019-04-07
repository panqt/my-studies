package pers.panqt.springcloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.panqt.springcloud.entities.User;

/**  @author panqt 2019/04/07 18:57
 *   
 */
@FeignClient("springcloud-provider")
public interface UserClientService {
    @GetMapping("user/get/{userid}")
    public User get(@PathVariable("userid") int userid);
}

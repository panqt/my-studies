package pers.panqt.springcloud.api;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pers.panqt.springcloud.entities.User;

/**  @author panqt 2019/04/07 21:44
 *   
 */
@Slf4j
public class UserFallbackFactory implements FallbackFactory<UserClientService> {
    @Override
    public UserClientService create(Throwable cause) {
        return new UserClientService() {
            @Override
            public User get(int userid) {
                return new User().setUserName("调用失败了,服务不可用,提供降级信息");
            }
        };
    }
}

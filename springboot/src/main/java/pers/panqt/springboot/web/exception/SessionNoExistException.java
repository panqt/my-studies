package pers.panqt.springboot.web.exception;

import lombok.extern.slf4j.Slf4j;

/**  @author panqt 2019/04/01 22:16
 *   
 */
@Slf4j
public class SessionNoExistException extends Exception{

    public SessionNoExistException(){
        super("session 为空");
    }
}

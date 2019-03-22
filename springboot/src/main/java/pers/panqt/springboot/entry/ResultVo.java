package pers.panqt.springboot.entry;

import lombok.Data;

/**  @auther panqt 2019/3/19 2:43
 */
@Data
public class ResultVo<T> {
    private int code = 200;

    private T data = null;

    private String message = "响应成功";

    public ResultVo(){

    }

    public ResultVo(T data){
        this.data = data;
    }

    public ResultVo(String message,T data){
        this.data = data;
        this.message = message;
    }

    public ResultVo(int code,String message){
        this.code = code;
        this.message = message;
    }
}

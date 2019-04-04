package pers.panqt.springboot.web.enums;

/**  @author panqt 2019/04/01 22:20
 *   
 */
public enum StatusCodeEnum {
    SUCCESS(200,"success"),
    UNKOWN_ERROR(500,"unkown error"),
    SESSION_NOT_EXIST(600,"session not exist"),
    PARAM_CHECK_ERROR(700,"param check error"),
    ARITHMETIC_ERROR(800,"arithmetic error");


    int code;
    String desc;

    StatusCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

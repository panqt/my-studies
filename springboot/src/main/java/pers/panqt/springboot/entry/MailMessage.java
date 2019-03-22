package pers.panqt.springboot.entry;

import lombok.Data;

/**  @auther panqt 2019/03/21 16:08
 */
@Data
public class MailMessage {
    private String titil;
    private String text;
    private String target;
}

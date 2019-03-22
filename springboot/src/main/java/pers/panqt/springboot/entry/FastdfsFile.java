package pers.panqt.springboot.entry;

import lombok.Data;

/** @author panqt    2019/03/18 5:13
 */
@Data
public class FastdfsFile {

    /**  base64 字符串
     */
    private String base64Text;

    /**  文件拓展名
     */
    private String exName;

    /**  fastdfs访问路径
     */
    private String visitUrl;

    /**  文件id 用于访问fastdfs
     */
    private String fileId;
}

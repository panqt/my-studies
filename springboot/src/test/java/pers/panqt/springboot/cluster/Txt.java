package pers.panqt.springboot.cluster;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.annotations.Document;

/**  @author panqt 2019/03/27 22:10
 *   
 */
@Slf4j
@Data
@Document(indexName = "txt",type = "txt")
public class Txt {

    //id
    private int id;

    //行数
    private int lineNo;

    //摘要
    private String summary;

    //文本
    private String txt;

    //文本2
    private String txt2;
}

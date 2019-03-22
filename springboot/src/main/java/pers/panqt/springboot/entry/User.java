package pers.panqt.springboot.entry;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Elasticsearch indexName索引名称 可以理解为数据库名 必须为小写 不然会报异常,type类型 可以理解为表名
 * lombok @Data不用再写 getter/setter 构造方法 toString等 https://www.jianshu.com/p/b6615e2bb346
 */
@Data
@Document(indexName = "user",type = "user")
public class User {

    /**
     * Elasticsearch id
     * */
    @Id
    private int userId;

    @Length(min = 1,max = 20,message = "名字不对")
    @NotBlank
    private String userName;
    private Timestamp createTime;
    private int departmentId;
    @Min(value = 1,message = "太小了")
    private int roleId;
}

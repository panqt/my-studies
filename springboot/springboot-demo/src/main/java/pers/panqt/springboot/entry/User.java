package pers.panqt.springboot.entry;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


//Elasticsearch indexName索引名称 可以理解为数据库名 必须为小写 不然会报异常,type类型 可以理解为表名
@Document(indexName = "user",type = "user")
public class User implements Serializable {

    @Id //Elasticsearch id
    private int userId;

    @Length(min = 1,max = 20,message = "名字不对")
    @NotBlank
    private String userName;
    private Timestamp createTime;
    private int departmentId;

    @Min(value = 1,message = "太小了")
    private int roleId;

    public User() {
    }

    public User(int userId, String userName, Timestamp createTime, int departmentId, int roleId) {
        this.userId = userId;
        this.userName = userName;
        this.createTime = createTime;
        this.departmentId = departmentId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                "}\n";
    }
}

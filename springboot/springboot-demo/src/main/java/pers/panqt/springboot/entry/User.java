package pers.panqt.springboot.entry;

import java.io.Serializable;
import java.util.Date;

/**
 *  @time       2019年02月01日	21:55
 *	@author     panqt
 *
 *	@comment    
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private Date createTime;
    private int departmentId;
    private int roleId;

    public User() {
    }

    public User(int userId, String userName, Date createTime, int departmentId, int roleId) {
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

    public void setCreateTime(Date createTime) {
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
                '}';
    }
}

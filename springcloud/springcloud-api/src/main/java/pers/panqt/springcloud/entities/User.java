package pers.panqt.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

/**  @author panqt 2019/04/07 3:45
 *   
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Timestamp createTime;
    private Integer departmentId;
    private Integer roleId;
}

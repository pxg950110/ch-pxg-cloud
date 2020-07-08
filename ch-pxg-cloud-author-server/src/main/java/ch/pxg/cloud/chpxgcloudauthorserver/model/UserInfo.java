package ch.pxg.cloud.chpxgcloudauthorserver.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * user_info
 * @author 
 */
@Data
public class UserInfo implements Serializable {

    private Integer id;

    private String userName;

    private String userPassword;

    private Date createTime;

    private Integer status;

    public UserInfo(String userName, Integer status) {
        this.userName = userName;
        this.status = status;
    }

    public UserInfo(String userName, String userPassword, Integer status, String salt) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.status = status;
        this.salt = salt;
    }

    public UserInfo(String userName, Integer status, String salt) {
        this.userName = userName;
        this.status = status;
        this.salt = salt;
    }

    //role
    private List<UserRole> roleList;
    /**
     * 加密盐
     */
    private String salt;
    private static final long serialVersionUID = 1L;
}
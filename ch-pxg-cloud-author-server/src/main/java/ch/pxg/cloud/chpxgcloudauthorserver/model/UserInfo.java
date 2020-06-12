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

    //role
    private List<UserRole> roleList;
    /**
     * 加密盐
     */
    private String salt;
    private static final long serialVersionUID = 1L;
}
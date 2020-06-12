package ch.pxg.cloud.chpxgcloudauthorserver.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_role
 * @author 
 */
@Data
public class UserRole implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;



}
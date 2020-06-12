package ch.pxg.cloud.chpxgcloudauthorserver.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user_permission
 * @author 
 */
@Data
public class UserPermission implements Serializable {
    private Integer userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}
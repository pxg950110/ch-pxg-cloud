package ch.pxg.cloud.chpxgcloudauthorserver.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tb_user
 * @author 
 */
@Data
public class TbUser implements Serializable {
    private Integer id;

    // 用户id -->userInfo.id
    private Integer userId;

    //邮箱
    private String email;

    //电话
    private String phone;

    // 昵称
    private String name;

    // 具体明细信息
    private String detailInfo;

    //状态
    private Integer status;

    //扩展字段 1-8
    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    private String extend6;

    private String extend7;

    private String extend8;

    //创建时间
    private Date createTime;

    private static final long serialVersionUID = 1L;

}
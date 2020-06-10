package ch.pxg.cloud.chpxgcloudwechat.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * bill_type_info
 * @author 
 */
@Data
public class BillTypeInfo implements Serializable {

    private Integer id;

    private String code;

    private String name;

    private String imageUrl;

    private String imageName;


    private String note;

    private Date createTime;


    private String imageType;

    private String userId;

    private static final long serialVersionUID = 1L;
}
package ch.pxg.cloud.chpxgcloudauthorserver.util;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 2020/7/2  16:32
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/7/2
 * @Version 1.0.0
 * @description </p>
 */
@Data
public class TokenEnity {
    /**
     * 用户ID
     */
    private Long userId;
    private String token;
    /**
     * 过期时间
     */
    private Date expireTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}

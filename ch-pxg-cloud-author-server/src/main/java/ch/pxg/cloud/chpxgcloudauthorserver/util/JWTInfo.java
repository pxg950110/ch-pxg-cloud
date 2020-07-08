package ch.pxg.cloud.chpxgcloudauthorserver.util;


import java.io.Serializable;
import java.util.HashMap;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/16
 * @Version 1.0.0
 * @description </p>
 */
public class JWTInfo implements IJWTInfo , Serializable {

    private  String userName;
    private String userId;
    private String name;

    public JWTInfo(String userName, String userId, String name) {
        this.userName = userName;
        this.userId = userId;
        this.name = name;
    }

    public JWTInfo(){

    }


    /**
     * 获取用户名
     * @return
     */
    @Override
    public String getUniqueName() {
        return userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户id
     * @return
     */
    @Override
    public String getId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取名称
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

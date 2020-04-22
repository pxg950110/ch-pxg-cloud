package ch.pxg.cloud.chpxgcloudrabbitmq.producer;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 2020/3/4  0:34
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/4
 * @Version 1.0.0
 * @description </p>
 */
public class LogMessage implements Serializable {

    private long id;
    private  String msgUid;
    private String msg;
    private String logLevel;
    private  String serviceType;
    private Date createTime;
    private  long userId;

    public LogMessage() {
    }

    public LogMessage(long id, String msgUid, String msg, String logLevel, String serviceType, Date createTime, long userId) {
        this.id = id;
        this.msgUid = msgUid;
        this.msg = msg;
        this.logLevel = logLevel;
        this.serviceType = serviceType;
        this.createTime = createTime;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsgUid() {
        return msgUid;
    }

    public void setMsgUid(String msgUid) {
        this.msgUid = msgUid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "id=" + id +
                ", msgUid='" + msgUid + '\'' +
                ", msg='" + msg + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                '}';
    }
}

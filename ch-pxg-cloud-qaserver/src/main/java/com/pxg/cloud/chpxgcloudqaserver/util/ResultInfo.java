package com.pxg.cloud.chpxgcloudqaserver.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResultInfo {
    @ApiModelProperty("返回状态 0成功 500失败 300警告")
    private long code;
    @ApiModelProperty("返回数据")
   private Object data;
    @ApiModelProperty("返回消息")
   private String message;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultInfo() {
    }

    public ResultInfo(long code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ResultInfo ok(Object data){
        return new ResultInfo(0,data,"成功");
    }

    public static   ResultInfo error(Object data){
        return new ResultInfo(500,data,"失败");
    }

    public static ResultInfo wain(Object data){
        return new ResultInfo(300,data,"警告");
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

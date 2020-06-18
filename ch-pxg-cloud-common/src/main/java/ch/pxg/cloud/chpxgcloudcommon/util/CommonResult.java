package ch.pxg.cloud.chpxgcloudcommon.util;
/**
 * <p>
 * 2020/4/15  16:13
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/15
 * @Version 1.0.0
 * @description </p>
 * 通用返回类
 */
public class CommonResult<T> {

    private long code;

    private String message;

    private T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public CommonResult() {
    }


    /**
     * 成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(
                HttpResultStatus.STATUS200.statusCode,
                HttpResultStatus.STATUS200.statusDescription
                , data
        );
    }

    /**
     * 成功返回
     * @param data
     * @param message 提示消息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(
                HttpResultStatus.STATUS200.statusCode,
                message
                , data
        );
    }

    /**
     * 失败返回
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> error() {

        return new CommonResult<T>(
                HttpResultStatus.STATUS500.statusCode,
                HttpResultStatus.STATUS500.statusDescription,
                null
        );
    }

    /**
     * 失败返回
     * @param message 提示消息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> error(String message) {

        return new CommonResult<T>(
                HttpResultStatus.STATUS500.statusCode,
                message,
                null
        );
    }


    /**
     * 参数验证错误
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validatefailed() {
        return new CommonResult<T>(
                HttpResultStatus.STATUS300.statusCode,
                HttpResultStatus.STATUS300.statusDescription,
                null
        );
    }

    /**
     * 参数验证错误
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validatefailed(String message) {
        return new CommonResult<T>(
                HttpResultStatus.STATUS300.statusCode,
                message,
                null
        );
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(HttpResultStatus.STATUS401.statusCode,
                HttpResultStatus.STATUS401.statusDescription,
                data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(HttpResultStatus.STATUS403.statusCode, HttpResultStatus.STATUS403.statusDescription, data);
    }


    /**
     *通用返回方法
     * @param data
     * @param httpResultStatus
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> commomResult(T data,HttpResultStatus httpResultStatus){
        return new CommonResult<T>(httpResultStatus.statusCode,httpResultStatus.statusDescription,data);
    }

    /**
     * 通用返回方法
     * @param data
     * @param httpResultStatus
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> commomResult(T data,HttpResultStatus httpResultStatus,String message){
        return new CommonResult<T>(httpResultStatus.statusCode,message,data);
    }

}



package ch.pxg.cloud.chpxgcloudauthorserver.util;

public interface IJWTInfo {

    /**
     * 获取用户名
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户id
     * @return
     */
    String getId();

    /**
     * 获取名称
     * @return
     */
    String getName();
}

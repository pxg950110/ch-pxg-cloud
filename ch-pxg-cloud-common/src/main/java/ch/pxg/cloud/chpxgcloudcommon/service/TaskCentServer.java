package ch.pxg.cloud.chpxgcloudcommon.service;

import java.util.List;

/**
 * <p>
 * 2020/6/18  11:36
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/18
 * @Version 1.0.0
 * @description </p>
 */
public interface TaskCentServer {
    /**
     * 开始任务计划
     * @param taskKey
     * @param groupName
     * @return
     */
    boolean start(String taskKey, String groupName);

    /**
     * 停止任务
     * @param taskKey
     * @param groupName
     * @return
     */
    boolean stop(String taskKey, String groupName);


    /**
     *重启任务
     * @param taskKey
     * @param groupName
     * @return
     */
    boolean restart(String taskKey, String groupName);


    /**
     * 移除任务计划
     * @param taskKey
     * @param groupName
     * @return
     */
    boolean removeJob(String taskKey, String groupName);

    /**
     * 获取所有正在运行的任务计划
     * @return
     */
    List all();

    /**
     * 清除所有定时任务
     */
    boolean removeAll();



}

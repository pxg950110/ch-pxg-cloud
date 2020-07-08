package ch.pxg.cloud.chpxgcloudcommon.service.impl;

import ch.pxg.cloud.chpxgcloudcommon.model.EmailCode;
import ch.pxg.cloud.chpxgcloudcommon.service.TaskCentServer;
import ch.pxg.cloud.chpxgcloudcommon.taskcenter.TaskFactory;
import com.alibaba.fastjson.JSONPObject;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Service
public class TaskCenterImpl implements TaskCentServer {

    private final Logger log = LoggerFactory.getLogger(TaskCenterImpl.class);
    // 定时任务类
    @Autowired
    private org.quartz.Scheduler scheduler;


    //  定时任务 添加
    /**
     * 执行定时任务
     * @param taskKey
     * @param groupName
     * @return
     */
    @Override
    public boolean start(String taskKey, String groupName) {
        try {
            // 判断是否存在
            JobKey jobKey = new JobKey(taskKey, groupName);
            // 检查任务是否存在
            if (scheduler.checkExists(jobKey)) {
                //任务存在
                return false;
            }
            EmailCode emailCode = new EmailCode();
            // 任务不存在 创建任务
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("taskKey", taskKey);
            jobDataMap.put("groupName", groupName);
            jobDataMap.put("type", "EMAILCODE");
            jobDataMap.put("beanName", "taskServer");

            // 每2分钟执行一次
            String cronStr = "/20 * * * * ?";
            //
            JobDetail jobDetail = JobBuilder.newJob(TaskFactory.class).withIdentity(taskKey, groupName)
                    .setJobData(jobDataMap).build();
            // cron表达式
            CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(cronStr);

            Trigger trigger = TriggerBuilder.newTrigger()
                    //
                    .withIdentity(taskKey, groupName)
                    .withSchedule(cron)
                    .build();
            //
            scheduler.scheduleJob(jobDetail, trigger);
            return true;
            //  定时器
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 停止任务
     * @param taskKey
     * @param groupName
     * @return
     */
    @Override
    public boolean stop(String taskKey, String groupName) {
        return false;
    }

    /**
     * 重启任务
     * @param taskKey
     * @param groupName
     * @return
     */
    @Override
    public boolean restart(String taskKey, String groupName) {
        return false;
    }

    /**
     * 移除任务计划
     * @param taskKey
     * @param groupName
     * @return
     */
    @Override
    public boolean removeJob(String taskKey, String groupName) {
        return false;
    }

    /**
     * 获取所有正在运行的任务计划
     * @return
     */
    @Override
    public List all() {
        // 获取所有任务计划
        try {
            //  获取所有分组
            List<String> groupList = scheduler.getTriggerGroupNames();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 清除所有定时任务
     */
    @Override
    public boolean removeAll() {
        // 获取正在执行的任务
        try {
            List<String> jobGroups = scheduler.getJobGroupNames();
            log.info("正在运行的job组：===>>>>{},size 为 ==》 {}", jobGroups.toString(), jobGroups.size());
//            GroupMatcher groupMatcher=GroupMatcher.groupContains();
            if (jobGroups.size() <= 0) {
                log.info("定时任务为空 ，未清除任何定时任务");
                return false;
            } else {
                //
                for (String groupName : jobGroups) {
                    // 定时任务
                    // 分组
                    GroupMatcher<JobKey> groupMatcher = GroupMatcher.groupContains(groupName);
                    // 获取分组下的所有定时计划
//                    Set<TriggerKey>  triggerKeys = scheduler.getTriggerKeys(groupMatcher);
                    //  任务keys
                    Set<JobKey> jobKeys = scheduler.getJobKeys(groupMatcher);
                    //
                    boolean b = scheduler.deleteJobs(new ArrayList<JobKey>(jobKeys));
                    if (b)
                        log.info("删除定时任务成功");
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return true;
    }
}


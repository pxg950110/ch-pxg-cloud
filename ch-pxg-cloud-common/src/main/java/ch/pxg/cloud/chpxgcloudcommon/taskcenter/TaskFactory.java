package ch.pxg.cloud.chpxgcloudcommon.taskcenter;

import ch.pxg.cloud.chpxgcloudcommon.service.impl.TaskServer;
import ch.pxg.cloud.chpxgcloudcommon.util.SpringContextUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 2020/6/18  17:46
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/18
 * @Version 1.0.0
 * @description </p>
 */
public class TaskFactory implements Job {
    private final Logger log= LoggerFactory.getLogger(TaskFactory.class);



    @Autowired
    private TaskServer taskServer;

    private void getTaskServer(String beanName) {
        this.taskServer = (TaskServer) SpringContextUtil.getBean(beanName);
    }
    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     *
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     * @param context
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        log.info("开始执行定时任务");
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        this.getTaskServer((String) jobDataMap.get("beanName"));
        // 获取jobDataMap
        if ( jobDataMap.get("type").equals("EMAILCODE")){
          taskServer.clearInvalidMailCode();
        }
    }
}

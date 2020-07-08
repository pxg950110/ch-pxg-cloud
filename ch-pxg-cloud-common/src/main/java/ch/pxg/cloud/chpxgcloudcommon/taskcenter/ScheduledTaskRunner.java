package ch.pxg.cloud.chpxgcloudcommon.taskcenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 2020/6/18  11:28
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/18
 * @Version 1.0.0
 * @description
 * 定时任务 开始是执行任务
 * </p>
 */
@Component
@Order(1)
public class ScheduledTaskRunner implements ApplicationRunner {
    private static Logger log = LoggerFactory.getLogger(ScheduledTaskRunner.class);
    /**
     * Callback used to run the bean.
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始注册需要自动自行的定时任务");
        log.info("定时任务注册完毕");
    }
}

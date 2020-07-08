package ch.pxg.cloud.chpxgcloudcommon.model.request;

import ch.pxg.cloud.chpxgcloudcommon.taskcenter.TaskType;
import lombok.Data;

/**
 * <p>
 * 2020/6/23  18:19
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/23
 * @Version 1.0.0
 * @description </p>
 */
@Data
public class TaskRequestVI {

    //任务类型
    private TaskType taskType;

    //每页的数量
    private  long pageCount;
    //页码
    private long pageSize;


}

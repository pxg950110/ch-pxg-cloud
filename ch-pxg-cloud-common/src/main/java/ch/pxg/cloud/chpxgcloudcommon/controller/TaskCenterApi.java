package ch.pxg.cloud.chpxgcloudcommon.controller;

import ch.pxg.cloud.chpxgcloudcommon.config.SysLog;
import ch.pxg.cloud.chpxgcloudcommon.model.request.TaskRequestVI;
import ch.pxg.cloud.chpxgcloudcommon.service.TaskCentServer;
import ch.pxg.cloud.chpxgcloudcommon.service.impl.TaskServer;
import ch.pxg.cloud.chpxgcloudcommon.taskcenter.TaskType;
import ch.pxg.cloud.chpxgcloudcommon.util.CommonResult;
import ch.pxg.cloud.chpxgcloudcommon.util.HttpResultStatus;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 2020/6/18  11:09
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/18
 * @Version 1.0.0
 * @description </p>
 */
@Api(description = "任务配置中心")
@RestController
@RequestMapping("/task/center")
public class TaskCenterApi {
    private static Logger log= LoggerFactory.getLogger(TaskCenterApi.class);
    @Autowired
    private TaskCentServer taskCentServer;
    @Autowired
    private TaskServer taskServer;

    @ApiOperation("测试")
    @GetMapping("/test")
    public void test() {
       taskServer.execShell();
    }

    @SysLog("日志")
    @ApiOperation("清除所有定时任务")
    @GetMapping("/remove/all")
    public String  removeAllJobs() {
        taskCentServer.removeAll();
        return  "执行成功";
    }


    @ApiOperation("获取所有任务类型")
    @GetMapping("/tasktype")
    public CommonResult<List<TaskType>> getAllTaskType(){
        return CommonResult.commomResult(TaskType.getAllEumn(), HttpResultStatus.STATUS200);
    }
    @ApiOperation("获取任务")
    @PostMapping("/task/list/info")
    public  CommonResult  getTask(@RequestBody TaskRequestVI taskRequestVI, HttpServletRequest request, HttpServletResponse response){
        return CommonResult.commomResult(null,HttpResultStatus.STATUS200);
    }
}

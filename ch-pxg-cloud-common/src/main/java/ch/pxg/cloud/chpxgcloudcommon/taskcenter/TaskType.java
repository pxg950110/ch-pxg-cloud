package ch.pxg.cloud.chpxgcloudcommon.taskcenter;

import ch.pxg.cloud.chpxgcloudcommon.util.BaseEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 2020/6/19  10:45
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/19
 * @Version 1.0.0
 * @description </p>
 */
public enum TaskType  implements BaseEnum {
    EMAILCODE(1,"SYSTEMJOB","taskServer","clearInvalidMailCode","系统任务"),
    SHELLJOB(2,"SHELLJOB","taskServer","execShell","执行shell脚本"),
    ETLJOB(3,"ETLJOB","taskServer","execETL","执行ETL的任务"),
    SQLJOB(4,"SQLJOB","taskServer","execSQL","执行SQL语句"),
    OTHERJOB(5,"OTHERJOB","taskServer","execOTHER","执行其他任务");
    Integer id;
    String emailCode;
    String serverBean;
    String serverMethod;
    String description;

    TaskType(Integer id, String emailCode, String serverBean, String serverMethod, String description) {
        this.id = id;
        this.emailCode = emailCode;
        this.serverBean = serverBean;
        this.serverMethod = serverMethod;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getServerBean() {
        return serverBean;
    }

    public void setServerBean(String serverBean) {
        this.serverBean = serverBean;
    }

    public String getServerMethod() {
        return serverMethod;
    }

    public void setServerMethod(String serverMethod) {
        this.serverMethod = serverMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * 获取获取枚举
     * @return
     */
    public static List<TaskType> getAllEumn() {
        List<TaskType> list = new ArrayList<>();
        list.addAll(Arrays.asList(values()));
        return list;
    }
}

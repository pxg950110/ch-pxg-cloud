package ch.pxg.cloud.chpxgcloudcommon.taskcenter;

import javax.naming.Name;
import java.io.Serializable;

/**
 * <p>
 * 2020/6/21  17:26
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/21
 * @Version 1.0.0
 * @description </p>
 */
public enum TriggerState implements Serializable {
//    NONE, NORMAL, PAUSED, COMPLETE, ERROR, BLOCKED
//无，正常，暂停，完成，错误，阻止
    NONE("NONE","无"),
    NORMAL("NORMAL","正常"),
    PAUSE("PAUSE","暂停"),
    COMPLETE("COMPLETE","完成"),
    ERROR("ERROR","错误"),
    BLOCKED("BLOCKED","阻止");

    String name;
    String description;

    TriggerState(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

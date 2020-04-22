package ch.pxg.cloud.chpxgcloudconfig.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appsystem.system_config")
public class SystemConfig {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    //应用名称
    @Column(name = "server_name")
    private String serverName;
    //应用信息
    @Column(name = "server_info")
    private String serverInfo;
    //应用模块
    @Column(name = "profile")
    private String profile;
    //应用环境
    @Column(name = "label")
    private String label;
    //应用版本
    @Column(name = "version")
    private String version;
    @Column(name = "create_time")
    private Date createTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    public String getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

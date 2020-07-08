package ch.pxg.cloud.chpxgcloudcommon.model.shelll;

/**
 * <p>
 * 2020/6/22  15:17
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/22
 * @Version 1.0.0
 * @description </p>
 */
public class ShellConnectModel {
    // ip
    private String hostName;
    // 端口
    private Integer port;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 过期时间
    private long timeOut;
    // 编码
    private String charSet;

    // 需要执行的shell脚本
    private String  execSHell;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getExecSHell() {
        return execSHell;
    }

    public void setExecSHell(String execSHell) {
        this.execSHell = execSHell;
    }
}

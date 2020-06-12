package ch.pxg.cloud.chpxgcloudmanager.model.reponse;

import ch.pxg.cloud.chpxgcloudmanager.model.SystemConfig;

import java.util.List;

/**
 * <p>
 * 2020/6/10  22:06
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/10
 * @Version 1.0.0
 * @description </p>
 */
public class ServerReponseVi {
    List<SystemConfig> systemConfigs;

    public ServerReponseVi() {
    }

    public ServerReponseVi(List<SystemConfig> systemConfigs) {
        this.systemConfigs = systemConfigs;
    }

    public List<SystemConfig> getSystemConfigs() {
        return systemConfigs;
    }

    public void setSystemConfigs(List<SystemConfig> systemConfigs) {
        this.systemConfigs = systemConfigs;
    }
}

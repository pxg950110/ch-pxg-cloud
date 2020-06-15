package ch.pxg.cloud.chpxgcloudmanager.server.impl;

import ch.pxg.cloud.chpxgcloudmanager.mapper.ConfigPropertiesMapper;
import ch.pxg.cloud.chpxgcloudmanager.mapper.SystemConfigMapper;
import ch.pxg.cloud.chpxgcloudmanager.model.ConfigProperties;
import ch.pxg.cloud.chpxgcloudmanager.model.SystemConfig;
import ch.pxg.cloud.chpxgcloudmanager.model.reponse.ServerReponseVi;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ConfigRequestVI;
import ch.pxg.cloud.chpxgcloudmanager.model.request.SaveServerConfigRequestVI;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ServerRequestVi;
import ch.pxg.cloud.chpxgcloudmanager.server.ManagerServer;
import ch.pxg.cloud.chpxgcloudmanager.util.CommonResult;
import ch.pxg.cloud.chpxgcloudmanager.util.HttpResultStatus;
import org.apache.catalina.util.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 2020/6/10  22:13
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/10
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class ManagerServerImpl implements ManagerServer, Serializable {

    @Autowired
    SystemConfigMapper systemConfigMapper;

    @Autowired
    ConfigPropertiesMapper configPropertiesMapper;

    /**
     * 获取所有服务的接口
     * @param serverRequestVi
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult<ServerReponseVi> getAllServer(ServerRequestVi serverRequestVi, HttpServletRequest request, HttpServletResponse response) {

        //获取所有服务
        return CommonResult.commomResult(new ServerReponseVi(systemConfigMapper.selectAll()), HttpResultStatus.STATUS200);
    }


    @Override
    public CommonResult<List<ConfigProperties>> getConfigByServerId(ConfigRequestVI configRequestVI, HttpServletRequest request, HttpServletResponse response) {
        //
        if (configRequestVI.getServerId() < 0)
            return CommonResult.commomResult(null, HttpResultStatus.STATUS300, "请确定所查询服务是否正确");
        return CommonResult.commomResult(configPropertiesMapper.selectByServerId(configRequestVI.getServerId()), HttpResultStatus.STATUS200);
    }


    /**
     * 获取单个配置的服务信息   v1.0版本只通过id查询
     * @param serverRequestVi
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult<SystemConfig> getServerInfo(ServerRequestVi serverRequestVi, HttpServletRequest request, HttpServletResponse response) {
        //serverId is not null
        if (serverRequestVi == null) {
            response.setStatus(HttpResultStatus.STATUS300.getStatusCode());
            return CommonResult.commomResult(null, HttpResultStatus.STATUS300, "请求参数为空");
        }
        // 通过主键查询服务
        SystemConfig systemConfig = systemConfigMapper.selectByPrimaryKey(serverRequestVi.getServerId());
        return CommonResult.commomResult(systemConfig, HttpResultStatus.STATUS200);
    }

    /**
     * 更新或者插入配置文件
     * @param saveServerConfigRequestVI
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult<String> saveServerConfig(SaveServerConfigRequestVI saveServerConfigRequestVI, HttpServletRequest request, HttpServletResponse response) {
        //服务的配置 key value 不允许为空
        if (StringUtils.isEmpty(saveServerConfigRequestVI.getPropertyKey()) || StringUtils.isEmpty(saveServerConfigRequestVI.getPropertyValue())) {
            response.setStatus(HttpResultStatus.STATUS400.getStatusCode());
            return CommonResult.commomResult("服务配置key && value 不允许为空", HttpResultStatus.STATUS400);
        }
        // 检查服务在库中是否存在
        if (systemConfigMapper.selectByPrimaryKey(saveServerConfigRequestVI.getServerId()) ==null) {
            response.setStatus(HttpResultStatus.STATUS400.getStatusCode());
            return CommonResult.commomResult("请求参数不存在    &&  请检查所选择的服务是否正确", HttpResultStatus.STATUS400);
        }

        // 插入或者更新数据 通过 key  serverId 查询 数据
        //  serverid key  唯一
        List<ConfigProperties> configPropertiesList = configPropertiesMapper.selectSelective(new ConfigProperties(saveServerConfigRequestVI.getPropertyKey(), saveServerConfigRequestVI.getServerId()));
        // saveServerConfigRequestVI
        ConfigProperties configProperties = new ConfigProperties(saveServerConfigRequestVI.getPropertyId(), saveServerConfigRequestVI.getPropertyKey(),
                saveServerConfigRequestVI.getPropertyValue(), saveServerConfigRequestVI.getServerId(), saveServerConfigRequestVI.getDescription());
        //数据不存在执行插入
        if (configPropertiesList.size() <= 0) {
            configPropertiesMapper.insert(configProperties);
        } else {
            // 数据存在执行更新操作
            configProperties.setServerId(configPropertiesList.get(0).getId());
            configPropertiesMapper.updateByPrimaryKey(configProperties);
        }
        return CommonResult.commomResult("保存成功", HttpResultStatus.STATUS200);
    }
}

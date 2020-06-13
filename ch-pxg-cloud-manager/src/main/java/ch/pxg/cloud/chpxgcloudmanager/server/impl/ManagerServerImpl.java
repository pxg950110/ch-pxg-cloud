package ch.pxg.cloud.chpxgcloudmanager.server.impl;

import ch.pxg.cloud.chpxgcloudmanager.mapper.ConfigPropertiesMapper;
import ch.pxg.cloud.chpxgcloudmanager.mapper.SystemConfigMapper;
import ch.pxg.cloud.chpxgcloudmanager.model.ConfigProperties;
import ch.pxg.cloud.chpxgcloudmanager.model.reponse.ServerReponseVi;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ConfigRequestVI;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ServerRequestVi;
import ch.pxg.cloud.chpxgcloudmanager.server.ManagerServer;
import ch.pxg.cloud.chpxgcloudmanager.util.CommonResult;
import ch.pxg.cloud.chpxgcloudmanager.util.HttpResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return  CommonResult.commomResult(new ServerReponseVi(systemConfigMapper.selectAll()), HttpResultStatus.STATUS200);
    }


    @Override
    public CommonResult<List<ConfigProperties>> getConfigByServerId(ConfigRequestVI configRequestVI, HttpServletRequest request, HttpServletResponse response) {
        //
        if (configRequestVI.getServerId()<0)
            return CommonResult.commomResult(null,HttpResultStatus.STATUS300,"请确定所查询服务是否正确");
        return CommonResult.commomResult(configPropertiesMapper.selectByServerId(configRequestVI.getServerId()),HttpResultStatus.STATUS200);
    }
}
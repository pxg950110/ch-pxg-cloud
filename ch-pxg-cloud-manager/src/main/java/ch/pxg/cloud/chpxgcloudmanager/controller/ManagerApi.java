package ch.pxg.cloud.chpxgcloudmanager.controller;

import ch.pxg.cloud.chpxgcloudmanager.model.ConfigProperties;
import ch.pxg.cloud.chpxgcloudmanager.model.SystemConfig;
import ch.pxg.cloud.chpxgcloudmanager.model.reponse.ServerReponseVi;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ConfigRequestVI;
import ch.pxg.cloud.chpxgcloudmanager.model.request.SaveServerConfigRequestVI;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ServerRequestVi;
import ch.pxg.cloud.chpxgcloudmanager.server.ManagerServer;
import ch.pxg.cloud.chpxgcloudmanager.server.impl.ManagerServerImpl;
import ch.pxg.cloud.chpxgcloudmanager.util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 2020/6/9  14:28
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/9
 * @Version 1.0.0
 * @description </p>
 */
@RestController
public class ManagerApi {
    private  static Logger log= LoggerFactory.getLogger(ManagerApi.class);
    @Autowired
    ManagerServer managerServer;
    @ApiOperation("测试")
    @GetMapping("test")
    public String test() {
        return "测试";
    }


    /**
     * 获取配置中的所有服务
     * @param serverRequestVi
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("获取所有配置中的服务")
    @PostMapping("/server/all/list")
    public CommonResult<ServerReponseVi>
    getAllServer(ServerRequestVi serverRequestVi ,
                 HttpServletRequest request,
                 HttpServletResponse response){
        return managerServer.getAllServer(serverRequestVi,request,response);
    }

    @ApiOperation("获取该服务下的配置信息")
    @GetMapping("/server/config/list")
    public CommonResult<List<ConfigProperties>> getConfigByServerId(ConfigRequestVI configRequestVI,
                                                                    HttpServletRequest request,
                                                                    HttpServletResponse response){
        return managerServer.getConfigByServerId( configRequestVI,  request,  response);
    }


    @ApiOperation("获取单个server")
    @GetMapping("/server/info")
    public CommonResult<SystemConfig> getServerInfo(ServerRequestVi serverRequestVi, HttpServletRequest request, HttpServletResponse response){

        return  managerServer.getServerInfo(serverRequestVi,request,response);
    }

    @ApiOperation("保存配置信息,单条")
    @PostMapping("/server/config/save")
    public CommonResult<String> saveServerConfig(@RequestBody  SaveServerConfigRequestVI  saveServerConfigRequestVI, HttpServletRequest request, HttpServletResponse response){
        return managerServer.saveServerConfig(saveServerConfigRequestVI,request,response);
    }

    // 关键配置信息 不做删除操作
    @DeleteMapping("/server/config/delete")
    @ApiOperation("删除单条配置")
    public CommonResult<String> deleteServerConfig(Integer configId,HttpServletRequest request,HttpServletResponse response){
        return managerServer.deleteServerConfig(configId,request,response);
    }
}

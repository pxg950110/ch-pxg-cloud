package ch.pxg.cloud.chpxgcloudmanager.server;

import ch.pxg.cloud.chpxgcloudmanager.model.reponse.ServerReponseVi;
import ch.pxg.cloud.chpxgcloudmanager.model.request.ServerRequestVi;
import ch.pxg.cloud.chpxgcloudmanager.util.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 2020/6/10  22:12
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/10
 * @Version 1.0.0
 * @description </p>
 */
public interface ManagerServer {


    CommonResult<ServerReponseVi>
    getAllServer(ServerRequestVi serverRequestVi,
                 HttpServletRequest request,
                 HttpServletResponse response);
}

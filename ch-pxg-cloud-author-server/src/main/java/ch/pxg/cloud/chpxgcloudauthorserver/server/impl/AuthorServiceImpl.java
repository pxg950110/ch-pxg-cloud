package ch.pxg.cloud.chpxgcloudauthorserver.server.impl;

import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserRegistVI;
import ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi.UserRegistResponseVI;
import ch.pxg.cloud.chpxgcloudauthorserver.server.AuthorService;
import ch.pxg.cloud.chpxgcloudauthorserver.util.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * <p>
 * 2020/4/23  14:36
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/4/23
 * @Version 1.0.0
 * @description </p>
 * 会员服务中心
 */
@Service
public class AuthorServiceImpl implements AuthorService  , Serializable {

    private static final long serialVersionUID = 2664724877017936511L;
    // v1.0版本aop 日志暂时不加入 1.0.0版本日志未采用mq
    //日志处理
    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    /**
     * 会员注册
     * @param registVI
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResult<UserRegistResponseVI> regist(UserRegistVI registVI, HttpServletRequest request, HttpServletResponse response) {
        log.info(registVI.getMessageId());
        // mybatis  改为jpa的操作
        return null;
    }
}

package ch.pxg.cloud.chpxgcloudauthorserver.server;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import ch.pxg.cloud.chpxgcloudauthorserver.util.ResultInfo;

public interface UserService {


    /**
     * 用户登录
     * @param userInfo
     * @return
     */
    ResultInfo login(UserInfo userInfo);


    /**
     * 通过邮箱获取验证码
     * @param emailUrl
     * @return
     */
    ResultInfo emailCode(String emailUrl);
}

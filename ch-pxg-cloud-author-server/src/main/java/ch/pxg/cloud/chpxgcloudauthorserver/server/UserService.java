package ch.pxg.cloud.chpxgcloudauthorserver.server;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import ch.pxg.cloud.chpxgcloudauthorserver.model.requestvi.UserVI;
import ch.pxg.cloud.chpxgcloudauthorserver.util.ResultInfo;

public interface UserService {


    /**
     * 用户登录
     * @param userInfo
     * @return
     */
    public ResultInfo login(UserInfo userInfo);

    /**
     * 用户注册
     * @param userVI
     * @return
     */
    public ResultInfo regist(UserVI userVI);


    /**
     * 通过邮箱获取验证码
     * @param emailUrl
     * @return
     */
    public ResultInfo emailCode(String emailUrl);
}

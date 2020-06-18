package ch.pxg.cloud.chpxgcloudcommon.service;

import ch.pxg.cloud.chpxgcloudcommon.util.CommonResult;
import ch.pxg.cloud.chpxgcloudcommon.util.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudcommon.util.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MailService {

    void sendMail(EmailCodeVI emailCodeVI);

    ResultInfo getMailInfo(String msgId);

    CommonResult<Boolean> checkMailCode(String msgId, String emailCode, HttpServletRequest request, HttpServletResponse response);
}

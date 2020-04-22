package ch.pxg.cloud.chpxgcloudcommon.service;

import ch.pxg.cloud.chpxgcloudcommon.util.EmailCodeVI;
import ch.pxg.cloud.chpxgcloudcommon.util.ResultInfo;

public interface MailService {

    public void sendMail(EmailCodeVI emailCodeVI);

    public ResultInfo getMailInfo(String msgId);
}

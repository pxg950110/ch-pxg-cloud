package ch.pxg.cloud.chpxgcloudauthorserver.model.responsevi;

import lombok.Data;

/**
 * <p>
 * 2020/6/16  10:40
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/16
 * @Version 1.0.0
 * @description </p>
 */
@Data
public class MailCodeResponseVI {

    String msgId;

    public MailCodeResponseVI() {
    }

    public MailCodeResponseVI(String msgId) {
        this.msgId = msgId;
    }
}

package ch.pxg.cloud.chpxgcloudrabbitmq.feignclient;

import ch.pxg.cloud.chpxgcloudrabbitmq.producer.EmailCodeVI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "common-server")
public interface CHCloudCommon {

    //发送简单邮件
    @GetMapping("/common/")
    String sendMail(@RequestParam String to);


    @GetMapping("/common/mail/code")
    public  void sendSimpleEmailCode(EmailCodeVI emailCodeVI);
}

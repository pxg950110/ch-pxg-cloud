package ch.pxg.cloud.chpxgcloudauthorserver.feignclient;

import ch.pxg.cloud.chpxgcloudauthorserver.util.EmailCodeVI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "rabbit-server")
public interface RabbitFeignClinet {

    @PostMapping("/rabbit/send/mail/code")
    public  void sendSimpleEmailCode(@RequestBody EmailCodeVI emailCodeVI);
}

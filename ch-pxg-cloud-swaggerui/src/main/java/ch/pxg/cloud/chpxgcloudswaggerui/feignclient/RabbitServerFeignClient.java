package ch.pxg.cloud.chpxgcloudswaggerui.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("rabbit-server")
public interface RabbitServerFeignClient {

    //parse url like /test
    @RequestMapping("/rabbit/")
    String getTest();
}

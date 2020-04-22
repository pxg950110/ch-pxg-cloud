package ch.pxg.cloud.chpxgcloudswaggerui.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sidecar-python")
public interface SidecarAPIFeignClient {

    @GetMapping("/user")
    Object getUser(@RequestParam String url);
}

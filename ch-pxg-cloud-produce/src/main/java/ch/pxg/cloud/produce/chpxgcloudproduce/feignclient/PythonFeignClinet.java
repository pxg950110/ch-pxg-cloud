package ch.pxg.cloud.produce.chpxgcloudproduce.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sidecar-python")
public interface PythonFeignClinet {

    @GetMapping("/gushi/list")
    public Object getGushiList(@RequestParam String url);

    @GetMapping("/gushi/content")
    public Object getGushiContent(@RequestParam String url);
}

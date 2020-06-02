package ch.pxg.cloud.chpxgcloudhadoopcommon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 2020/5/22  21:13
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/5/22
 * @Version 1.0.0
 * @description </p>
 */
@RestController
public class TestController  {

    @GetMapping("/")
    public String test(){
        return  "hello hadoop";
    }
}

package ch.pxg.cloud.chpxgcloudswaggerui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChPxgCloudSwaggeruiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudSwaggeruiApplication.class, args);
    }

}

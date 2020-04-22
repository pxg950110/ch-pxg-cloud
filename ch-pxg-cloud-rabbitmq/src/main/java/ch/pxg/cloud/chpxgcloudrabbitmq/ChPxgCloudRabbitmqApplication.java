package ch.pxg.cloud.chpxgcloudrabbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ChPxgCloudRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudRabbitmqApplication.class, args);
    }
}

package ch.pxg.cloud.produce.chpxgcloudproduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ChPxgCloudProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudProduceApplication.class, args);
    }

}

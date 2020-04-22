package ch.pxg.cloud.gateway.chpxgcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
//@EnableOAuth2Sso
public class ChPxgCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudGatewayApplication.class, args);
    }

}

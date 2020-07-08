package ch.pxg.cloud.chpxgcloudcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableSwagger2
public class ChPxgCloudCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudCommonApplication.class, args);
    }

}

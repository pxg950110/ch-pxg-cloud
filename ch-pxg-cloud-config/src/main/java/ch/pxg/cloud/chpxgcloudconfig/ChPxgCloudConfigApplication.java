package ch.pxg.cloud.chpxgcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ChPxgCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudConfigApplication.class, args);
    }

}

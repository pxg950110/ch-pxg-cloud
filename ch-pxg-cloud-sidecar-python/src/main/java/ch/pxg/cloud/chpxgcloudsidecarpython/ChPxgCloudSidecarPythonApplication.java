package ch.pxg.cloud.chpxgcloudsidecarpython;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
public class ChPxgCloudSidecarPythonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChPxgCloudSidecarPythonApplication.class, args);
    }

}

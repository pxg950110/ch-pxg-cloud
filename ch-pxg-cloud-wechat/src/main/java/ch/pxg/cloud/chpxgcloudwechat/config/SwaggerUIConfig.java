package ch.pxg.cloud.chpxgcloudwechat.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/2/29
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
@EnableSwagger2
public class SwaggerUIConfig {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger API")
                .description("微信相关后台接口程序")
                .termsOfServiceUrl("")
                .contact(new Contact("wd", "", ""))
                .version("2.0")
                .build();
    }
}

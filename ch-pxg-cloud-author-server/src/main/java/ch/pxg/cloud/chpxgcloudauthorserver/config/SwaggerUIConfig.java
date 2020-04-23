package ch.pxg.cloud.chpxgcloudauthorserver.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

/**
 * <p>
 * 2020/2/29  18:10
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
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
                .build()
                .securitySchemes(secruitySchemes())
                .securityContexts(securityContexts());
    }

    /**
     * 头部增加author
     * @return
     */
    private List<ApiKey> secruitySchemes(){
        List<ApiKey> apiKeyList=new ArrayList<>();
        //
        apiKeyList.add(
                new ApiKey("Authorization","Authorization","header")
        );
        return apiKeyList;
    }

    private  List<SecurityContext> securityContexts(){
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder().securityReferences(
                        defaultAuth()
                ).forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build()
        );
        return securityContexts;
    }

    // default auth
    public List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope=new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization",authorizationScopes));
        return securityReferences;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger API")
                .description("用户权限管理服务")
                .termsOfServiceUrl("")
                .contact(new Contact("ch_pxg", "www.pxgandppm.top", "pxg950110@163.com"))
                .version("1.0.0")
                .build();
    }
}

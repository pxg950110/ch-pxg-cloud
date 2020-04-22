package ch.pxg.cloud.gateway.chpxgcloudgateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 2020/2/29  13:48
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
@Component
@Primary
@AllArgsConstructor
public class SwaggerUIProvider implements SwaggerResourcesProvider {

    public static final String API_URI ="/v2/api-docs" ;
    private  final RouteLocator routeLocator;
    private  final GatewayProperties gatewayProperties;
    /**
     * Retrieves an instance of the appropriate type. The returned object may or may not be a new
     * instance, depending on the implementation.
     * @return an instance of the appropriate type
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResources=new ArrayList<>();
        List<String> routes=new ArrayList<>();
        routeLocator.getRoutes().subscribe(route ->routes.add(route.getId()));
        gatewayProperties.getRoutes().stream().filter(
                routeDefinition -> routes.contains(routeDefinition.getId())
        ).forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                .forEach(predicateDefinition -> swaggerResources.add(swaggerResource(routeDefinition.getId(),
                        predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX+"0")
                .replace("/**",API_URI)))));
        return swaggerResources;
    }

    private SwaggerResource swaggerResource(String name, String locatgon) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(locatgon);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}

package ch.pxg.cloud.gateway.chpxgcloudgateway.fitler;

import ch.pxg.cloud.gateway.chpxgcloudgateway.config.SwaggerUIProvider;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

/**
 * <p>
 * 2020/2/29  17:37
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
@Deprecated
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {
    private static final String HEADER_NAME = "X-Forwarded-Prefix";
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange,chain)->{
            ServerHttpRequest request =exchange.getRequest();
            String path=request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path,SwaggerUIProvider.API_URI)){
                return chain.filter(exchange);
            }
            String basePath=path.substring(0,path.lastIndexOf(SwaggerUIProvider.API_URI));
            ServerHttpRequest newRequest=request.mutate().header(HEADER_NAME,basePath).build();
            ServerWebExchange newExchange=exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}

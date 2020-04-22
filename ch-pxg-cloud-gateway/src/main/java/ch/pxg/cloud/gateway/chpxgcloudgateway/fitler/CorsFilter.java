package ch.pxg.cloud.gateway.chpxgcloudgateway.fitler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * <p>
 * 2020/3/11  17:26
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/11
 * @Version 1.0.0
 * @description </p>
 * 解决跨域调用问题
 */
@Configuration
public class CorsFilter  {

    @Bean
    public CorsWebFilter corsFilters(){
        CorsConfiguration config=new CorsConfiguration();
        config.setAllowCredentials(Boolean.TRUE);
        //方法
        config.addAllowedMethod("*");
        //origin
        config.addAllowedOrigin("*");
        // header
        config.addAllowedHeader("*");
        // 自定义token
      UrlBasedCorsConfigurationSource
       source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**",config);
        return  new CorsWebFilter(source);
    }


}

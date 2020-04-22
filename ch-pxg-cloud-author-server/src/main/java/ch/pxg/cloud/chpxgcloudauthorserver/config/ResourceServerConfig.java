package ch.pxg.cloud.chpxgcloudauthorserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 2020/3/17  0:41
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/17
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling().authenticationEntryPoint(
                (request,response,authException)->response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED
                )
        ).and()
                .authorizeRequests()                //例外
                .antMatchers("/user/email/code","/test",//
                        "/v2/api-docs","/user/login",//
                        "/oauth/token",//
                        "/user/regist"//
                        ,"/test/test"
                ).permitAll()
                .anyRequest().authenticated().and().httpBasic();
    }
}

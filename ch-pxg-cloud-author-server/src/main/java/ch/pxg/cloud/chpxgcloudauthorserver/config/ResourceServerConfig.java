package ch.pxg.cloud.chpxgcloudauthorserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
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

    /**
     * 定义免登陆接口
     * @param http
     * @throws Exception
     */
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
                        ,"/test/test",
                        "/auth/**"
                ).permitAll()
                .anyRequest().authenticated().and().httpBasic();
    }
}

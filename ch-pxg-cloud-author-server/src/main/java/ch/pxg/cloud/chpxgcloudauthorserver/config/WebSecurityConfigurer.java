package ch.pxg.cloud.chpxgcloudauthorserver.config;

import ch.pxg.cloud.chpxgcloudauthorserver.server.UserDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/15
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

@Autowired
private UserDetailServiceImpl userDetailService;

private static Logger log= LoggerFactory.getLogger(WebSecurityConfigurer.class);

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("测试验证");
        // http config
        http.authorizeRequests()
        .anyRequest().authenticated()
                .and().csrf().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        log.info("test----04");
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("test----05");
       auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Bean
    public BCryptPasswordEncoder myEncoder(){
        return new BCryptPasswordEncoder(6);
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        log.info("aasdadsdsa");
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        // 设置user
        provider.setUserDetailsService(userDetailService);
        //禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        //
        provider.setPasswordEncoder(myEncoder());
        return provider;
    }
}

package ch.pxg.cloud.chpxgcloudauthorserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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




    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http config
        http.authorizeRequests()
        .anyRequest().authenticated()
                .and().csrf().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

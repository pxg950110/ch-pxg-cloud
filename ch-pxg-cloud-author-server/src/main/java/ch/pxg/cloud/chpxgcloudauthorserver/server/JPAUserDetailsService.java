package ch.pxg.cloud.chpxgcloudauthorserver.server;

import ch.pxg.cloud.chpxgcloudauthorserver.dao.UserInfoJpa;
import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * <p>
 * 2020/3/15  23:24
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/15
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class JPAUserDetailsService implements UserDetailsService {

    private final Logger log= LoggerFactory.getLogger(JPAUserDetailsService.class);
    @Autowired
    private UserInfoJpa userInfoJpa;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo=userInfoJpa.getByUserName(userName);
        log.info(userName);
        log.info("===============");
        log.info(userInfo.toString());
        if (userInfo==null){
            throw new UsernameNotFoundException(userName);
        }
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority("admin");
        User user=new User(userInfo.getUserName(),userInfo.getUserPassword(), Collections.singleton(simpleGrantedAuthority));
        return user;
    }
}

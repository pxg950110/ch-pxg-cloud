package ch.pxg.cloud.chpxgcloudauthorserver.config;

import ch.pxg.cloud.chpxgcloudauthorserver.server.UserDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/15
 * @Version 1.0.0
 * @description </p>
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    private static Logger log= LoggerFactory.getLogger(AuthorizationServerConfig.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 令牌存储
     * @return
     */
    public TokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }



    /**
     * jwt资源令牌转换器
     * @return
     */
    public JwtAccessTokenConverter accessTokenConverter(){
        return new JwtAccessTokenConverter(){
            /**
             * 重写增强token的方法
             * @param accessToken  资源令牌
             * @param authentication  认证
             * @return  增强的OAuth2AccessToken对象
             */
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                String userName=authentication.getUserAuthentication().getName();
                User user= (User) authentication.getUserAuthentication().getPrincipal();
                Map<String ,Object> infoMap=new HashMap<>();
                infoMap.put("userName",userName);
                infoMap.put("roles",user.getAuthorities());
                ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(infoMap);
                return super.enhance(accessToken, authentication);
            }
        };
    }

    /**
     * security配置
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        log.info("test----01");
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        log.info("test----02");
        clients.inMemory()
                .withClient("android")
                .scopes("xx")
                .secret("android")
                .authorizedGrantTypes("password","authorization_code","refresh_token")
                .and()
                .withClient("webapp")
                .scopes("xx")
                .authorizedGrantTypes("implicit")
                .and()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        log.info("test----03");
     endpoints.authenticationManager(this.authenticationManager);
     endpoints.accessTokenConverter(accessTokenConverter());
     endpoints.tokenStore(tokenStore());
    }
}

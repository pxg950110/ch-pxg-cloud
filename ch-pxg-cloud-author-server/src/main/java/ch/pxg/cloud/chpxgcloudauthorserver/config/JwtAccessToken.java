package ch.pxg.cloud.chpxgcloudauthorserver.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 2020/6/12  10:28
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/12
 * @Version 1.0.0
 * @description  token 生成类 自定义JwtAccessToken转换器
 * </p>
 */
public class JwtAccessToken extends JwtAccessTokenConverter implements Serializable {
    private static final long serialVersionUID = 718257653017425256L;


    /**
     * 生成token
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        return super.enhance(accessToken, authentication);
    }

    /**
     * 解析token
     * @param value
     * @param map
     * @return
     */
    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        return super.extractAccessToken(value, map);
    }
}
package ch.pxg.cloud.chpxgcloudauthorserver.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.operator.KeyWrapper;
import springfox.documentation.spi.service.contexts.SecurityContext;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.util.Date;

/**
 * <p>
 * 2020/7/3  11:02
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/7/3
 * @Version 1.0.0
 * @description </p>
 */
public class JwtHelperUtil {

    /**
     * 生成token
     * @return
     */
    public static String createJWT(
          JWTInfo jwtInfo,
            String base64Security,
            long TTLMills
    ){
        // 签名算法  HS256
        SignatureAlgorithm signatureAlgorith=SignatureAlgorithm.HS256;
        //当前的时间
        long nowMills=System.currentTimeMillis();
        //当前时间
        Date now=new Date(nowMills);
        //生成签名密钥
        byte[] apiKeySecretBytes= DatatypeConverter.parseBase64Binary(base64Security);
        //
        Key signingKey=new SecretKeySpec(apiKeySecretBytes,signatureAlgorith.getJcaName());

        //jwt参数
        JwtBuilder jwtBuilder= Jwts.builder();
        //设置类型
        jwtBuilder.setHeaderParam("type","JWT");
        //用户名
        jwtBuilder.claim("uniqueName",jwtInfo.getUniqueName());
        jwtBuilder.claim("userId",jwtInfo.getId());
        jwtBuilder.claim("userName",jwtInfo.getName());
        jwtBuilder.signWith(signatureAlgorith,signingKey);
        //
        //过期时间
        if (TTLMills>=0){
            jwtBuilder.setExpiration(new Date(nowMills+TTLMills)).setNotBefore(now);
        }
        //生成JWT
        return  jwtBuilder.compact();
    }


    public static void main(String[] args) {
        String   token=createJWT(new JWTInfo("admin","124514","admin"),Md5Util.md5Encode("admin"),-1);
        System.out.println(token);
        Claims claims=Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Md5Util.md5Encode("admin")))
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);

    }
}

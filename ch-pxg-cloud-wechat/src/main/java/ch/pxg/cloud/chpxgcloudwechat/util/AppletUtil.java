package ch.pxg.cloud.chpxgcloudwechat.util;

import ch.pxg.cloud.chpxgcloudwechat.config.WxProgramConfig;
import ch.pxg.cloud.chpxgcloudwechat.model.OpenIdModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/12
 * @Version 1.0.0
 * @description </p>
 * 微信小程序相关后台接口
 */
public class AppletUtil {
    private  static Logger log= LoggerFactory.getLogger(AppletUtil.class);
    /**
     *
     * @param code
     * @return  小程序官方接口获取每个人唯一的openId
     */
    public static OpenIdModel getOpenIdByCode(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WxProgramConfig.APPID + "&secret=" + WxProgramConfig.SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        // 发送请求
        CloseableHttpClient httpClient= HttpClients.createDefault();
        // 小程序官方发送get请求
        HttpGet httpGet=new HttpGet(url);
        //返回
        CloseableHttpResponse response=null;
        InputStream inputStream = null;
        StringBuilder result = new StringBuilder();
        OpenIdModel openIdModel = new OpenIdModel();
        try {
            // 获取返回
            response = httpClient.execute(httpGet);
            //返回的实体类
            HttpEntity httpEntity = response.getEntity();

            inputStream = httpEntity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                //这里需要使用fastjson来提取一下内容
                JSONObject jsonpObject = JSON.parseObject(line);
                openIdModel = new OpenIdModel(jsonpObject.getString("openid"), jsonpObject.getString("session_key"));
                log.info(openIdModel.toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
        return openIdModel;


    }
}

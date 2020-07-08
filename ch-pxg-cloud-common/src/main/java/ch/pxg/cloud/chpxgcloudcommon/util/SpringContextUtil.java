package ch.pxg.cloud.chpxgcloudcommon.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 2019/11/3  17:45
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2019/11/3
 * @Version 1.0.0
 * @description    </p>
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取bean
     * @param name bean name
     * @return
     */
    public static Object getBean(String name) {
        return SpringContextUtil.applicationContext.getBean(name);
    }
}
package ch.pxg.cloud.chpxgcloudcommon.config;

import java.lang.annotation.*;

/**
 * <p>
 * 2020/6/23  10:56
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/23
 * @Version 1.0.0
 * @description </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog  {
    String value() default "";
    
}

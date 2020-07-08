package ch.pxg.cloud.chpxgcloudcommon.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class SysAspect {
    private static Logger log= LoggerFactory.getLogger(SysAspect.class);

    /**
     *
     */
    @Pointcut("@annotation( ch.pxg.cloud.chpxgcloudcommon.config.SysLog)")
//    @Pointcut("execution(public * ch.pxg.cloud.chpxgcloudcommon..*.*(..))")
    public void logPoinCut(){

    }

    @Before("logPoinCut()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
//        logger.info("debefe");
//        接收到请求，记录请求内容
        log.info("测试");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        try {
            //
            HttpServletRequest request = attributes.getRequest();
            //记录下请求内容
            log.info("url:{}", request.getRequestURL().toString());
            log.info("HTTP_METHOD:{}", request.getMethod());
            log.info("IP:{}", request.getRemoteAddr());
            log.info("CLASS_METHOD:{}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());
            log.info("ARGS:{}", Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //处理完成后
    @AfterReturning(returning = "ret", pointcut = "logPoinCut()")
    public void doAfterReturn(Object ret) throws Exception {
        log.info("测试方法");
         log.info("方法的返回值:{}", ret);
    }

    //后置异常通知
    @AfterThrowing("logPoinCut()")
    public void dobThrows(JoinPoint joinPoint) {
        log.error("方法{}异常执行.....", joinPoint.getSignature().getName());
    }

    //后置最终通知
    @After("logPoinCut()")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        log.info("方法最后执行...");
    }

    @Around("logPoinCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Exception {
        log.info("方法环绕start...");
        try {
            Object o = joinPoint.proceed();
            log.info("方法环绕proceed，结果是 :{}", o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }
}

package ch.pxg.cloud.chpxgcloudcommon.service.impl;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import ch.pxg.cloud.chpxgcloudcommon.mapper.EmailCodeMapper;
import ch.pxg.cloud.chpxgcloudcommon.model.EmailCode;
import ch.pxg.cloud.chpxgcloudcommon.util.CommonUtil;
import ch.pxg.cloud.chpxgcloudcommon.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>
 * 2020/6/18  16:17
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/18
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class TaskServer {

    //    private final static Executor executor = Executors.newCachedThreadPool();//启用多线程
    // 启用多线程
    @Autowired
    private EmailCodeMapper emailCodeMapper;
    @Autowired
    private RedisUtil redisUtil;
    private final Logger log = LoggerFactory.getLogger(TaskServer.class);

    /**
     * 更改后台数据库中无效的邮箱验证码
     */
    public void clearInvalidMailCode() {
        //
        String msgId = CommonUtil.UUID();
        log.info("生成任务执行的任务id:{}", msgId);
        log.info("{}  ==>开始查询数据库中状态为0 的邮箱验证码", msgId);
        EmailCode emailCode = new EmailCode();
        emailCode.setStatus(0);
        List<EmailCode> emailCodes = emailCodeMapper.selectSelective(emailCode);
        // 待执行条数
        log.info("{}  ==>待执行数据条数：{}", msgId, emailCodes.size());
        // 多线程执行
        log.info("{}  ==>开启多线程执行", msgId);
        // 多线程
        Executor EXECUTOR = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(emailCodes.size());
        for (EmailCode emailCode1 : emailCodes) {
            EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                   try {
                       log.info("{}  ==>多线程执行任务，线程ID:{}", msgId, Thread.currentThread().getId());
                       log.info("{}  ==>多线程执行任务，线程ID:{},查询key是否有效", msgId, Thread.currentThread().getId());
                       if (!redisUtil.hasKey(emailCode1.getMsgId())) {
                           log.info("{}  ==>多线程执行任务，线程ID:{},key无效 key:{}", msgId, Thread.currentThread().getId(),emailCode1.getMsgId());
                           emailCodeMapper.updateStatusbyPrimary(emailCode1.getId());
                       }else{
                           log.info("{}  ==>多线程执行任务，线程ID:{},key有效key:{}", msgId, Thread.currentThread().getId(),emailCode1.getMsgId());
                       }
                   }catch (Exception e){
                       e.printStackTrace();
                   }finally {
                       countDownLatch.countDown();
                       log.info("{}  ==>多线程执行任务，线程ID:{} 线程执行结束", msgId, Thread.currentThread().getId());
                   }
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}==>任务执行结束", msgId);
    }

    // 智能   推荐



    /**
     * 执行shell脚本
     * @return
     */
    public boolean execShell(){
        InputStream stdOut=null;
        InputStream stdErr=null;
        String outStr="";
        String outErr="";
        try {
            log.info("连接到远程的ssh服务器");
            Connection connection=new Connection("192.168.174.131",22);
            connection.connect();
            boolean b=connection.authenticateWithPassword("root","pxg950110");
            if (!b){
                log.info("连接失败");
                return false;
            }
            else
                log.info("连接成功");
            // 创建session
            Session session=connection.openSession();
            session.execCommand("cd  /testinfo/\n" +
                    "./test.sh");
            stdOut=new StreamGobbler(session.getStdout());

            outStr=processStream(stdOut, Charset.defaultCharset().toString());
            System.out.println(outStr.replaceAll("\n","\\\\n"));
            stdErr =new StreamGobbler(session.getStderr());
            outErr=processStream(stdErr,Charset.defaultCharset().toString());
            session.waitForCondition(ChannelCondition.EXIT_STATUS,1000*5*60);
            log.info(outStr.replaceAll("\n","\\\\n"));
//            log.info(outErr);
            int ret=session.getExitStatus();
            stdOut.close();
            stdErr.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
      return  false;
    }
    private String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer();
        while (in.read(buf) != -1) {
            sb.append(new String(buf));
        }
        return sb.toString();
    }


    //  执行  etl   调度计划
    public boolean execETL(){
        return false;
    }
    // 执行 其他任务计划
    public  boolean execOTHER(){
        return false;
    }

    /**
     * 执行sql任务
     * @return
     */
    public boolean execSQL(){return false;}


}

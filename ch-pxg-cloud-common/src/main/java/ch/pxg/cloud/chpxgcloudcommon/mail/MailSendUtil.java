package ch.pxg.cloud.chpxgcloudcommon.mail;

import com.sun.mail.smtp.SMTPAddressFailedException;
import com.sun.mail.smtp.SMTPAddressSucceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * <p>
 * 2020/3/9  22:31
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/9
 * @Version 1.0.0
 * @description </p>
 */
@Component
public class MailSendUtil {

    @Autowired
    private  JavaMailSender javaMailSender;
    private static Logger log= LoggerFactory.getLogger(MailSendUtil.class);
    /**
     * 发送简单邮件
     * @param subject        邮箱标题
     * @param text           邮箱内容
     * @param to             接收方
     * @param from           发送方
     */
    public  void sendSimpleMail(
                                      String subject,
                                      String text,
                                      String to,
                                      String from) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        log.info("邮件发送开始");
//        simpleMailMessage.setCc("aassda");
//        simpleMailMessage.setBcc("暂定");
        //默认的from
        if (from == null) {
            from = "皮小怪和皮皮妹的空间<hyw1339141902@126.com>";
        }
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        javaMailSender.send(simpleMailMessage);
        log.info("邮件发送结束");
    }
    /**
     * 获取 Sender 多实例发送
     * @return
     */
    public static JavaMailSenderImpl createMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.126.com");
        sender.setPort(25);
        sender.setUsername("hyw1339141902@126.com");
        sender.setPassword("ch0312");
        sender.setDefaultEncoding("Utf-8");
//        sender.set
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout",0+"");
        p.setProperty("mail.smtp.auth","true");
        sender.setJavaMailProperties(p);

        return sender;
    }

    public static void main(String[] args) {
     new MailSendUtil().sendSimpleMail(
              "aaa","aa","pxg950110@163.com",null
      );
    }
}

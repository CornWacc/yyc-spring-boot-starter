package com.corn.boot.util;


import com.corn.boot.error.BizError;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * @author yyc
 * @apiNote 邮箱验证
 */
public class EmailSend {
    public static void sendEmail(String email) {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "smtp.qq.com");
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("791621554@qq.com"));
            message.setSubject("注册成功");
            message.setText("欢迎注册CornBlog");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            Transport transport = session.getTransport();
            transport.connect("791621554@qq.com", "xqvtuvrtruvgbcbe");
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizError("邮件发送失败");
        }

    }

    /** todo 邮件
     * 1.邮件认证
     * 2.带图片的邮件
     * */
}

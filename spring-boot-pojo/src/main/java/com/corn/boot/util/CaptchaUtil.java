package com.corn.boot.util;

import com.corn.boot.base.ImageCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Random;


/**
 * @author yyc
 * @apiNote 图形验证码
 * */
public class CaptchaUtil {

    private static Logger log = LoggerFactory.getLogger(CaptchaUtil.class);

    private static String random4numbers(){

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < 4 ; i++){
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static ImageCode outputImage(){

        String random4numbers = random4numbers();
        Random random = new Random();

        //创建图片对象
        BufferedImage bufferedImage = new BufferedImage(100,40,BufferedImage.TYPE_INT_RGB);
        //获取画布
        Graphics2D g = bufferedImage.createGraphics();
        //设置背景
        g.setColor(Color.lightGray);
        g.fillRect(0,0,100,40);//填充整个屏幕
        g.setColor(Color.BLACK);
        g.setFont(new Font("微软雅黑",Font.PLAIN,30));
        g.drawString(random4numbers,10,30);

        //随机生成4条线
        for(int i = 0 ; i < 15 ; i++){
            g.setColor(Color.getHSBColor(random.nextFloat(),random.nextFloat(),random.nextFloat()));
            g.drawLine(random.nextInt(100),random.nextInt(40),random.nextInt(100),random.nextInt(40));
        }


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            ImageIO.write(bufferedImage,"png",byteArrayOutputStream);

        }catch (Exception e){
            log.info("获取登录验证码失败");
        }
        String base64 = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        base64 = base64.replaceAll("\n","").replaceAll("\r","");

        ImageCode imageCode = new ImageCode(base64,random4numbers);
        return imageCode;
    }
}

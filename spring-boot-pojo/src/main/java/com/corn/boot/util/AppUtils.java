package com.corn.boot.util;

import com.corn.boot.error.BizError;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/**
 * 序列号生成工具
 */
public class AppUtils {


    private static final char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 生成指定接口的时间序列号
     */
    public static String appCode(String interfaceName) {
        String date = DateUtils.dateForMateForConnect(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(interfaceName);
        stringBuffer.append(date);
        return stringBuffer.toString();
    }

    /**
     * 生成用户id
     */
    public static String userIdCreate() {
        StringBuilder builder = new StringBuilder();
        builder.append("us");
        for (int i = 0; i < 14; i++) {
            builder.append(chr[new Random().nextInt(chr.length)]);
        }
        return String.valueOf(builder);
    }

    /**
     * 生成Token
     *
     * @return
     */
    public static String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
           // BASE64Encoder encoder = new BASE64Encoder();
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new BizError("生成token失败");
        }
    }

    /**
     * 生成对应id
     */
    public static String correspondingCreate(String name) {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        for (int i = 0; i < 12; i++) {
            builder.append(chr[new Random().nextInt(chr.length)]);
        }
        builder.append(DateUtils.dateForMateForConnect(new Date()));
        return String.valueOf(builder);
    }
}

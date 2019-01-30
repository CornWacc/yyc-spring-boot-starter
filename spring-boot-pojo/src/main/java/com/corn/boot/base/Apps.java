package com.corn.boot.base;


import org.apache.commons.lang3.StringUtils;

/**
 * @author yyc
 * @apiNote 获取配置文件
 * */
public class Apps {

    /**
     * 启动文件
     * */
    private static final String SPRING_PROFILE_ACTIVE = "spring.profiles.active";

    /**
     * 启动端口
     * */
    private static final String SERVER_PORT = "server.port";

    public static void setSpringProfileActive(String active){
        if(!StringUtils.isNotBlank(System.getProperty(SPRING_PROFILE_ACTIVE))){
            System.setProperty(SPRING_PROFILE_ACTIVE,active);
            System.out.println(active);
        }
    }

    public static void setServerPort(String port){
        if(!StringUtils.isNotBlank(System.getProperty(SERVER_PORT))){
            System.setProperty(SERVER_PORT,port);
        }
    }
}

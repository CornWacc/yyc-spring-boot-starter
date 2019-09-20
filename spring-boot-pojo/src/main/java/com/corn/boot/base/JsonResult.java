package com.corn.boot.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yyc
 * @apiNote 通用返回json类
 */
public class JsonResult extends Base {

    private static final Logger log = LoggerFactory.getLogger(JsonResult.class);

    private Object data;

    private String msg;

    private Integer code;

    private Boolean success;

    public JsonResult(Object o,String msg){
        if(o instanceof BaseRes){
            BaseRes baseRes = (BaseRes) o;
            if(checkSuccess(baseRes.getCode())){
                this.msg = baseRes.getMessage();
                this.success = true;
            }
        }
    }

    public JsonResult(String msg,Boolean success){

    }

    private boolean checkSuccess(Integer code){
        switch (code){
            case 200:
                return true;
            case 500 : return false;
            default:
                return false;
        }
    }
}

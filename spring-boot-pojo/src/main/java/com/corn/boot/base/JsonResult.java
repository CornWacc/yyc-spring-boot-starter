package com.corn.boot.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yyc
 * @apiNote 通用返回json类
 */
public class JsonResult extends Base {

    private static final Logger log = LoggerFactory.getLogger(JsonResult.class);

    public static final String SUCCESS_MSG = "SUCCESS";

    public static final String FAIL_MSG = "FAIL";

    private Object data;

    private String msg;

    private int code;

    private String status;

    public JsonResult(int code) {
        this.code = code;
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(Object object) {

        if(BaseRes.class.isAssignableFrom(object.getClass())){
            this.data = object;
            BaseRes res = (BaseRes) object;
            this.status = res.getStatus().code().toUpperCase();
            this.msg = res.getMessage();
        }else{
            this.status = FAIL_MSG;
            this.msg = "系统出错啦！！";
            log.error("回调参数返回错误!");
        }
    }

    public JsonResult(Object object, String msg) {
        this.data = object;
        this.msg = msg;
    }

    public JsonResult(Object object, String msg, int code) {
        this.data = object;
        this.msg = msg;
        this.code = code;
    }

    public JsonResult(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public JsonResult(String status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

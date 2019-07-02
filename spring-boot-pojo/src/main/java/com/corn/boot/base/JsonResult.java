package com.corn.boot.base;

/**
 * @author yyc
 * @apiNote 通用返回json类
 */
public class JsonResult extends Base {

    private static final String SUCCESS_MSG = "SUCCESS";

    private static final String FIAL_MSG = "FAIL";

    private Object object;

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
        this.object = object;
    }

    public JsonResult(Object object, String msg) {
        this.object = object;
        this.msg = msg;
    }

    public JsonResult(Object object, String msg, int code) {
        this.object = object;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
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
}

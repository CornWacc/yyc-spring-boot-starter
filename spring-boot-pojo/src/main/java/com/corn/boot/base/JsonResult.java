package com.corn.boot.base;

import com.corn.boot.base.pojobase.BaseRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yyc
 * @apiNote 通用返回json类
 */
public class JsonResult {

    private static final Logger log = LoggerFactory.getLogger(JsonResult.class);

    /**
     * 返回实体
     * */
    private Object data;

    /**
     * 返回信息
     * */
    private String msg;

    /**
     * 响应码
     * */
    private Integer code;

    /**
     * 是否执行成功
     * */
    private Boolean success;

    public JsonResult(Object o){
        if(o instanceof BaseRes){
            BaseRes baseRes = (BaseRes) o;
            if(checkSuccess(baseRes.getCode(),baseRes)){
                this.msg = "执行成功";
                this.success = true;
                this.code = HttpBase.HTTP_RESPONSE_SUCCESS_CODE;
            }else{
                this.msg = baseRes.getMessage();
                this.success = false;
                this.code = HttpBase.HTTP_RESPONSE_FAIL_CODE;
            }
        }
        this.data = o;
    }

    public JsonResult(Object o,String msg){
        if(o instanceof BaseRes){
            BaseRes baseRes = (BaseRes) o;
            if(checkSuccess(baseRes.getCode(),baseRes)){
                this.msg = msg;
                this.success = true;
                this.code = HttpBase.HTTP_RESPONSE_SUCCESS_CODE;
            }else{
                this.msg = baseRes.getMessage();
                this.success = false;
                this.code = HttpBase.HTTP_RESPONSE_FAIL_CODE;
            }
        }
        this.data = o;
    }

    public JsonResult(String msg,Boolean success){
        this.msg = msg;
        this.success = true;
        this.code = HttpBase.HTTP_RESPONSE_SUCCESS_CODE;
    }

    private boolean checkSuccess(Integer code,BaseRes res){
        switch (code){
            case 200:
                return true;
            case 401:
                res.setMessage("用户权限异常！");
                return false;
            default:
                return false;
        }
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

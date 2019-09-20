package com.corn.boot.base;


import com.corn.boot.enums.StatusEnum;

public class BaseRes extends Base {
    private static final long serialVersionUID = 7964440651025911165L;
    /**
     * 结果状态
     */
    private StatusEnum status;
    /**
     * 描述
     */
    private String message;

    /**
     * 错误码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return this.status == StatusEnum.SUCCESS;
    }

    public boolean isFail() {
        return this.status == StatusEnum.FAIL;
    }

    public boolean isProcessing() {
        return this.status == StatusEnum.PROCESSING;
    }

}

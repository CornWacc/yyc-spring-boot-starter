package com.corn.boot.error;

/**
 * 异常处理类
 */
public class BizError extends RuntimeException {
    private static final long serialVersionUID = 2492449662231853945L;

    private Integer code;

    public BizError() {
        super();
    }

    /**
     * 构建一个<code>BizError.java</code>
     * msg为自定义信息
     * 此方法适用于 直接抛出自己定义的信息
     *
     * @param msg
     */
    public BizError(String msg) {
        super(msg);
    }

    public BizError(String message, Throwable cause) {
        super(message, cause);
    }

    public BizError(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

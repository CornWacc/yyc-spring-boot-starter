package com.corn.boot.base;

/**
 * @author yyc
 * @apiNote Http响应
 * */
public class HttpBase extends Base {

    /* 业务层处理返回接口层设置的正确响应码 */
    public static final Integer HTTP_RESPONSE_SUCCESS_CODE = 200;

    /* 业务层处理返回接口层设置的错误响应码 */
    public static final Integer HTTP_RESPONSE_FAIL_CODE = 500;

    /* 业务层处理返回接口层设置的权限错误响应码 */
    public static final Integer HTTP_RESPONSE_ROLE_CODE = 401;

    /* 业务处理返回默认应答 */
    public static final String HTTP_RESPONSE_ERROR_CODE = "系统繁忙！请联系管理员!";

}

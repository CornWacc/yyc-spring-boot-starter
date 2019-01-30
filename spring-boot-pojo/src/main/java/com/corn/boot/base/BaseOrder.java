package com.corn.boot.base;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 基础入参实现类
 * */
public class BaseOrder  extends Base implements Serializable {
    private static final long serialVersionUID = -2427019332806095916L;
    /**
     * 此流水号没有任何业务规则，只是为了跟踪业务形态设置
     */
    private String serialNo;




    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public void orderCheck(){
        if(StringUtils.isBlank(this.serialNo)){
            throw new BizError("服务序列号不能为空");
        }
    }


}

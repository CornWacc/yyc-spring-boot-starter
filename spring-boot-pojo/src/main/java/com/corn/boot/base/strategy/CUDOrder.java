package com.corn.boot.base.strategy;

import com.corn.boot.base.pojobase.BaseOrder;

public class CUDOrder extends BaseOrder {

    protected String cudType;

    public String getCudType() {
        return cudType;
    }

    public void setCudType(String cudType) {
        this.cudType = cudType;
    }
}

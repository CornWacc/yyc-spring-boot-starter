package com.corn.boot.base.factory;

import com.corn.boot.base.pojobase.BaseOrder;
import com.corn.boot.base.strategy.CudExecuteInterface;

/**
 * @author yyc
 * @apiNote 通用CUD工厂基类
 * */
public abstract class AbstractCUDFactory<T extends CudExecuteInterface,O extends BaseOrder> {

    protected final String CREATE_CODE = "CREATE";

    protected final String UPDATE_CODE = "UPDATE";

    protected final String DELETE_CODE = "DELETE";

    public abstract T createStrategy(O order);
}

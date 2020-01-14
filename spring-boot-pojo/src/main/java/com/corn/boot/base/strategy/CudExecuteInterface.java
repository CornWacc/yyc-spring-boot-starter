package com.corn.boot.base.strategy;

import com.corn.boot.base.pojobase.BaseRes;

/**
 * @author yyc
 * @apiNote 基础策略执行类
 * */
public interface CudExecuteInterface<O extends CUDOrder,R extends BaseRes> {

    R execute(O order);
}

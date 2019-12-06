package com.corn.boot.base.strategy;

/**
 * @author yyc
 * @apiNote 基础策略执行类
 * */
public interface BaseCUDInterface<O extends CUDOrder> {

    void execute(O order);
}

package com.corn.boot.base;


/**
 * @author yyc
 * @apiNote 分页入参数据实体
 * */
public class PageParamInfo extends Base {

    private static final long serialVersionUID = -8924760560916377493L;

    /**
     * 页数
     * */
    private Integer pageNum;

    /**
     * 页面展示条数
     * */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

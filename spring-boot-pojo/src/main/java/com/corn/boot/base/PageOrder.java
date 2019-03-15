package com.corn.boot.base;


/**
 * @author yyc
 * @apiNote 分页实体
 * */
public class PageOrder extends BaseOrder {

    private static final long serialVersionUID = -2427119332806095916L;

    /**
     * 每页展示页数
     * */
    private Integer pageSize;

    /**
     * 页码
     * */
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}

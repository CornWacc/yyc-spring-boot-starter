package com.corn.boot.base;


import java.util.Date;

/**
 * @author yyc
 * @apiNote 分页实体
 */
public class PageOrder extends BaseOrder {

    private static final long serialVersionUID = -2427119332806095916L;

    /**
     * 每页展示页数
     */
    private Integer pageSize = 10;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 关键字
     * */
    private String keyWord;

    /**
     * 开始时间
     * */
    private String startTime;

    /**
     * 结束时间
     * */
    private String endTime;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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

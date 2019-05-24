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
    private Integer pageSize;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 关键字
     * */
    private String keyWord;

    /**
     * 开始时间
     * */
    private Date startTime;

    /**
     * 结束时间
     * */
    private Date endTime;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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

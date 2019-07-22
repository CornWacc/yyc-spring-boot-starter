package com.corn.boot.base;


import java.util.Date;

/**
 * @author yyc
 * @apiNote 分页实体
 */
public class PageOrder extends BaseOrder {

    private static final long serialVersionUID = -2427119332806095916L;


    /**
     * 分页实体
     * */
    private PageParamInfo pageParamInfo;

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

    public PageParamInfo getPageParamInfo() {
        return pageParamInfo;
    }

    public void setPageParamInfo(PageParamInfo pageParamInfo) {
        this.pageParamInfo = pageParamInfo;
    }
}

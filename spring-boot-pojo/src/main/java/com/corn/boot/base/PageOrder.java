package com.corn.boot.base;


import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * @author yyc
 * @apiNote 分页实体
 */
public class PageOrder extends BaseOrder {

    private static final long serialVersionUID = -2427119332806095916L;


    /**
     * 分页实体
     * */
    private PageParamInfo pageParamInfo = new PageParamInfo();

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

    private Integer pageNum;

    private Integer pageSize;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if(!ObjectUtils.isEmpty(pageNum)){
            this.pageNum = pageNum;
        }else{
            this.pageNum = 1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(ObjectUtils.isEmpty(pageSize)){
            this.pageSize = 10;
        }else{
            this.pageSize = pageSize;
        }
    }

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
        //自动往分页实体里面封装参数
        if(!ObjectUtils.isEmpty(this.pageNum) && !ObjectUtils.isEmpty(this.pageSize)) {
            pageParamInfo.setPageNum(this.pageNum);
            pageParamInfo.setPageSize(this.pageSize);
            return pageParamInfo;
        }

        return pageParamInfo;
    }

    public void setPageParamInfo(PageParamInfo pageParamInfo) {
        this.pageParamInfo = pageParamInfo;
    }
}

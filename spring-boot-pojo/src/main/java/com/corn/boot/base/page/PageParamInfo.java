package com.corn.boot.base.page;


import com.corn.boot.base.pojobase.Base;
import org.springframework.util.ObjectUtils;

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

    public PageParamInfo(){

    }

    public PageParamInfo(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        if(ObjectUtils.isEmpty(this.pageNum) || this.pageNum.equals(0)){
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(ObjectUtils.isEmpty(this.pageSize) || this.pageSize.equals(0)){
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

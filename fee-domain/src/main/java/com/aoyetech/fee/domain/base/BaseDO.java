/*
 * 
 */
// Created on 2013-3-21

package com.aoyetech.fee.domain.base;

import java.io.Serializable;

/**
 * @author joe.chen
 */
@SuppressWarnings("serial")
public class BaseDO implements Serializable {

    /**
     * 
     */

    public String  startTime; // 开始时间限制

    public String  endTime;  // 结束时间限制

    public Integer start;    // 其实记录

    public Integer count;    // 查询条数

    public String  condition; // 查询条件

    public String  order;     // 排序条件

    
    public String getOrder() {
        return order;
    }

    
    public void setOrder(String order) {
        this.order = order;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

package com.aoyetech.fee.domain.baseinfo;

import com.aoyetech.fee.domain.base.BaseDO;

/**
 * 描述：飞机信息基本标
 * 
 * @author 黄磊
 * Date 2014-09-17
 */
public class AirBaseInfoDO extends BaseDO{

    private static final long serialVersionUID = 1L;

    /**
     * 流水id
     */
    private Integer id;

    /**
     * 飞机名
     */
    private String creaftName;

    /**
     * 驾驶员
     */
    private String driverName;

    /**
     * 人物名
     */
    private String personName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 扩展字段1
     */
    private String extendsation;

    /**
     * setter for column 流水id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter for column 流水id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * setter for column 飞机名
     */
    public void setCreaftName(String creaftName) {
        this.creaftName = creaftName;
    }

    /**
     * getter for column 飞机名
     */
    public String getCreaftName() {
        return this.creaftName;
    }

    /**
     * setter for column 驾驶员
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * getter for column 驾驶员
     */
    public String getDriverName() {
        return this.driverName;
    }

    /**
     * setter for column 人物名
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * getter for column 人物名
     */
    public String getPersonName() {
        return this.personName;
    }

    /**
     * setter for column 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * getter for column 创建时间
     */
    public String getCreateTime() {
        return this.createTime;
    }

    /**
     * setter for column 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * getter for column 修改时间
     */
    public String getUpdateTime() {
        return this.updateTime;
    }

    /**
     * setter for column 扩展字段1
     */
    public void setExtendsation(String extendsation) {
        this.extendsation = extendsation;
    }

    /**
     * getter for column 扩展字段1
     */
    public String getExtendsation() {
        return this.extendsation;
    }
}
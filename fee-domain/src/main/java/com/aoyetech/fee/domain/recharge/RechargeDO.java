package com.aoyetech.fee.domain.recharge;

import com.aoyetech.fee.domain.base.BaseDO;

/**
 * 描述：充值表
 * @author 黄磊
 * Date 2014-09-17
 */
public class RechargeDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private Integer           id;
    /***
     * 应用id
     */
    private Integer           appId;

    /**
     * 点数名
     */
    private String            rechargeName;

    /**
     * 点数
     */
    private Integer           rechargeNumber;

    /**
     * 描述
     */
    private String            description;

    /**
     * 建立时间
     */
    private String            createTime;

    /**
     * 修改时间
     */
    private String            updateTime;

    /**
     * 扩展字段
     */
    private String            extendation;
    /***
     * 计费编码
     */
    private String            feeCode;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    /**
     * setter for column 流水号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter for column 流水号
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * setter for column 点数名
     */
    public void setRechargeName(String rechargeName) {
        this.rechargeName = rechargeName;
    }

    /**
     * getter for column 点数名
     */
    public String getRechargeName() {
        return this.rechargeName;
    }

    /**
     * setter for column 点数
     */
    public void setRechargeNumber(Integer rechargeNumber) {
        this.rechargeNumber = rechargeNumber;
    }

    /**
     * getter for column 点数
     */
    public Integer getRechargeNumber() {
        return this.rechargeNumber;
    }

    /**
     * setter for column 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter for column 描述
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * setter for column 建立时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * getter for column 建立时间
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
     * setter for column 扩展字段
     */
    public void setExtendation(String extendation) {
        this.extendation = extendation;
    }

    /**
     * getter for column 扩展字段
     */
    public String getExtendation() {
        return this.extendation;
    }
}
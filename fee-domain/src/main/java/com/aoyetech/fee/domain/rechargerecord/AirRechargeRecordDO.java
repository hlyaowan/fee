package com.aoyetech.fee.domain.rechargerecord;

import com.aoyetech.fee.domain.base.BaseDO;

/**
 * 描述：充值记录表
 * @author 黄磊
 * Date 2014-09-17
 */
public class AirRechargeRecordDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private Integer           id;

    /**
     * 支付名
     */
    private String            rechargeName;

    /**
     * 钻石数
     */
    private Integer           diamondNumber;

    /**
     * 描述
     */
    private String            decribe;

    /**
     * 建立时间
     */
    private String            createTime;

    /**
     * 修改时间
     */
    private String            updateTime;

    /**
     * 扩展1
     */
    private String            extendation;

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
     * setter for column 支付名
     */
    public void setRechargeName(String rechargeName) {
        this.rechargeName = rechargeName;
    }

    /**
     * getter for column 支付名
     */
    public String getRechargeName() {
        return this.rechargeName;
    }

    /**
     * setter for column 钻石数
     */
    public void setDiamondNumber(Integer diamondNumber) {
        this.diamondNumber = diamondNumber;
    }

    /**
     * getter for column 钻石数
     */
    public Integer getDiamondNumber() {
        return this.diamondNumber;
    }

    /**
     * setter for column 描述
     */
    public void setDecribe(String decribe) {
        this.decribe = decribe;
    }

    /**
     * getter for column 描述
     */
    public String getDecribe() {
        return this.decribe;
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
     * setter for column 扩展1
     */
    public void setExtendation(String extendation) {
        this.extendation = extendation;
    }

    /**
     * getter for column 扩展1
     */
    public String getExtendation() {
        return this.extendation;
    }
}
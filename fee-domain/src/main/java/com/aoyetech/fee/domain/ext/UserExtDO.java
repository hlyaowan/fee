package com.aoyetech.fee.domain.ext;

import com.aoyetech.fee.domain.base.BaseDO;

/**
 * 描述：用户基本信息扩展表
 * @author 黄磊
 * Date 2014-09-17
 */
public class UserExtDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private Integer           id;

    /**
     * 用户id
     */
    private Integer           userId;

    /**
     * 手机号码
     */
    private String            mobile;

    /**
     * 移动过来的userId
     */
    private String            authId;

    /**
     * 业务编码
     */
    private String            cpServiceId;

    /**
     * cp编码
     */
    private String            cpId;

    /**
     * MD5key值
     */
    private String            keymd5;

    /**
     * 渠道号
     */
    private String            channelId;

    /**
     * 添加时间
     */
    private String            addTime;

    /**
     * 自定义字段
     */
    private String            contentInfo;

    /**
     * 地区
     */
    private String            region;

    /**
     * 飞机名
     */
    private String            craftName;

    /**
     * 驾驶员名
     */
    private String            driverName;

    /**
     * 人物名
     */
    private String            personName;

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
     * setter for column 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * getter for column 用户id
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * setter for column 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * getter for column 手机号码
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * setter for column 移动过来的userId
     */
    public void setAuthId(String authId) {
        this.authId = authId;
    }

    /**
     * getter for column 移动过来的userId
     */
    public String getAuthId() {
        return this.authId;
    }

    /**
     * setter for column 业务编码
     */
    public void setCpServiceId(String cpServiceId) {
        this.cpServiceId = cpServiceId;
    }

    /**
     * getter for column 业务编码
     */
    public String getCpServiceId() {
        return this.cpServiceId;
    }

    /**
     * setter for column cp编码
     */
    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    /**
     * getter for column cp编码
     */
    public String getCpId() {
        return this.cpId;
    }

    /**
     * setter for column MD5key值
     */
    public void setKeymd5(String keymd5) {
        this.keymd5 = keymd5;
    }

    /**
     * getter for column MD5key值
     */
    public String getKeymd5() {
        return this.keymd5;
    }

    /**
     * setter for column 渠道号
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * getter for column 渠道号
     */
    public String getChannelId() {
        return this.channelId;
    }

    /**
     * setter for column 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * getter for column 添加时间
     */
    public String getAddTime() {
        return this.addTime;
    }

    /**
     * setter for column 自定义字段
     */
    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    /**
     * getter for column 自定义字段
     */
    public String getContentInfo() {
        return this.contentInfo;
    }

    /**
     * setter for column 地区
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * getter for column 地区
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * setter for column 飞机名
     */
    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }

    /**
     * getter for column 飞机名
     */
    public String getCraftName() {
        return this.craftName;
    }

    /**
     * setter for column 驾驶员名
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * getter for column 驾驶员名
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
}
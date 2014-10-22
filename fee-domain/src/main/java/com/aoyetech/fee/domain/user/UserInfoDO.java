package com.aoyetech.fee.domain.user;

import com.aoyetech.fee.domain.base.BaseDO;

/***
 * 
 * @author huanglei
 * @version $Id: UserInfoDO.java,v 0.1 2014年9月17日 上午12:03:47 hlyaowan Exp $
 */
public class UserInfoDO extends BaseDO {
    private static final long serialVersionUID = 1L;
    /***
     * 流水id
     */
    private Integer           id;
    /***
     * 用户名
     */
    private String            name;
    /***
     * 密码
     */
    private String            password;
    /***
     * 积分
     */
    private Integer           integral;
    /***
     * 飞机等级
     */
    private Integer           grade;
    /***
     * 砖石
     */
    private Integer           masonry;
    /***
     * 历史最高分
     */
    private Integer           historynum;
    /***
     * 
     */
    private Integer           currentblackstage;
    /***
     * 
     */
    private Integer           isblackstateunlock;
    /***
     * 
     */
    private Integer           isnewplayer;
    /***
     * 
     */
    private Integer           appId;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMasonry() {
        return masonry;
    }

    public void setMasonry(Integer masonry) {
        this.masonry = masonry;
    }

    public Integer getHistorynum() {
        return historynum;
    }

    public void setHistorynum(Integer historynum) {
        this.historynum = historynum;
    }

    public Integer getCurrentblackstage() {
        return currentblackstage;
    }

    public void setCurrentblackstage(Integer currentblackstage) {
        this.currentblackstage = currentblackstage;
    }

    public Integer getIsblackstateunlock() {
        return isblackstateunlock;
    }

    public void setIsblackstateunlock(Integer isblackstateunlock) {
        this.isblackstateunlock = isblackstateunlock;
    }

    public Integer getIsnewplayer() {
        return isnewplayer;
    }

    public void setIsnewplayer(Integer isnewplayer) {
        this.isnewplayer = isnewplayer;
    }

}

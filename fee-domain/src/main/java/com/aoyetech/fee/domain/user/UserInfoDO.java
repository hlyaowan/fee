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
    private int               id;
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
    private int               integral;
    /***
     * 飞机等级
     */
    private int               planegrade;
    /***
     * 砖石
     */
    private int               masonry;
    /***
     * 历史最高分
     */
    private int               historynum;
    /***
     * 绿藻宝贝
     */
    private int               petone;
    /***
     * 螳螂战士
     */
    private int               pettwo;
    /***
     * 璐璐之心
     */
    private int               petthree;
    /***
     * 黄金瓢虫
     */
    private int               petfour;
    /***
     * 铁甲钢虫
     */
    private int               petfive;
    /***
     * 无敌萌宠
     */
    private int               petsix;
    /***
     * 
     */
    private int               currentblackstage;
    /***
     * 
     */
    private int               isblackstateunlock;
    /***
     * 
     */
    private int               isnewplayer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getPlanegrade() {
        return planegrade;
    }

    public void setPlanegrade(int planegrade) {
        this.planegrade = planegrade;
    }

    public int getMasonry() {
        return masonry;
    }

    public void setMasonry(int masonry) {
        this.masonry = masonry;
    }

    public int getHistorynum() {
        return historynum;
    }

    public void setHistorynum(int historynum) {
        this.historynum = historynum;
    }

    public int getPetone() {
        return petone;
    }

    public void setPetone(int petone) {
        this.petone = petone;
    }

    public int getPettwo() {
        return pettwo;
    }

    public void setPettwo(int pettwo) {
        this.pettwo = pettwo;
    }

    public int getPetthree() {
        return petthree;
    }

    public void setPetthree(int petthree) {
        this.petthree = petthree;
    }

    public int getPetfour() {
        return petfour;
    }

    public void setPetfour(int petfour) {
        this.petfour = petfour;
    }

    public int getPetfive() {
        return petfive;
    }

    public void setPetfive(int petfive) {
        this.petfive = petfive;
    }

    public int getPetsix() {
        return petsix;
    }

    public void setPetsix(int petsix) {
        this.petsix = petsix;
    }

    public int getCurrentblackstage() {
        return currentblackstage;
    }

    public void setCurrentblackstage(int currentblackstage) {
        this.currentblackstage = currentblackstage;
    }

    public int getIsblackstateunlock() {
        return isblackstateunlock;
    }

    public void setIsblackstateunlock(int isblackstateunlock) {
        this.isblackstateunlock = isblackstateunlock;
    }

    public int getIsnewplayer() {
        return isnewplayer;
    }

    public void setIsnewplayer(int isnewplayer) {
        this.isnewplayer = isnewplayer;
    }

}

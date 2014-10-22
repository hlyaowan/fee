package com.aoyetech.fee.biz.rechage;

import java.util.List;

import com.aoyetech.fee.domain.recharge.RechargeDO;

public interface RechargeManager {

    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<RechargeDO> getRechargeList(Integer start,Integer count,Integer appId);
    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public RechargeDO getRechargeEntity(RechargeDO RechargeDO);

    /**
     * 描述： select count _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getRechargeCount(RechargeDO RechargeDO);

    /**
     * 描述： insert into _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertRecharge(RechargeDO RechargeDO);

    /**
     * 描述： update _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateRecharge(RechargeDO RechargeDO);

    /**
     * 描述： delete from _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteRecharge(RechargeDO RechargeDO);
}

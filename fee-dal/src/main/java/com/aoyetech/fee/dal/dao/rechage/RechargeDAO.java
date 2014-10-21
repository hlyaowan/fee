package com.aoyetech.fee.dal.dao.rechage;

import java.util.List;

import com.aoyetech.fee.domain.recharge.RechargeDO;


public interface RechargeDAO {

    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<RechargeDO> getRechargeList(RechargeDO rechargeDO);
    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public RechargeDO getRechargeEntity(RechargeDO rechargeDO);

    /**
     * 描述： select count _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getRechargeCount(RechargeDO rechargeDO);

    /**
     * 描述： insert into _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertRecharge(RechargeDO rechargeDO);

    /**
     * 描述： update _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateRecharge(RechargeDO rechargeDO);

    /**
     * 描述： delete from _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteRecharge(RechargeDO rechargeDO);
}

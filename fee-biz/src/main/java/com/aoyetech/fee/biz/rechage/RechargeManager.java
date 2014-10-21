package com.aoyetech.fee.biz.rechage;

import java.util.List;

import com.aoyetech.fee.domain.recharge.RechargeDO;

public interface RechargeManager {

    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<RechargeDO> getAirRechargeList(int start,int count);
    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public RechargeDO getAirRechargeEntity(RechargeDO airRechargeDO);

    /**
     * 描述： select count air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirRechargeCount(RechargeDO airRechargeDO);

    /**
     * 描述： insert into air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirRecharge(RechargeDO airRechargeDO);

    /**
     * 描述： update air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirRecharge(RechargeDO airRechargeDO);

    /**
     * 描述： delete from air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirRecharge(RechargeDO airRechargeDO);
}

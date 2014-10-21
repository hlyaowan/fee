package com.aoyetech.fee.dal.dao.rechage;

import java.util.List;

import com.aoyetech.fee.domain.recharge.AirRechargeDO;

public interface AirRechargeDAO {

    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AirRechargeDO> getAirRechargeList(AirRechargeDO airRechargeDO);
    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public AirRechargeDO getAirRechargeEntity(AirRechargeDO airRechargeDO);

    /**
     * 描述： select count air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirRechargeCount(AirRechargeDO airRechargeDO);

    /**
     * 描述： insert into air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirRecharge(AirRechargeDO airRechargeDO);

    /**
     * 描述： update air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirRecharge(AirRechargeDO airRechargeDO);

    /**
     * 描述： delete from air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirRecharge(AirRechargeDO airRechargeDO);
}

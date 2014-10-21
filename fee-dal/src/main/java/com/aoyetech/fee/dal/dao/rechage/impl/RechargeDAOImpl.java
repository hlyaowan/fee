package com.aoyetech.fee.dal.dao.rechage.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechage.RechargeDAO;
import com.aoyetech.fee.domain.recharge.AirRechargeDO;


@Repository
public class RechargeDAOImpl extends MybatisTemplate implements RechargeDAO {

    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<AirRechargeDO> getAirRechargeList(AirRechargeDO airRechargeDO) {
        return super.queryForList("airRecharge_select", airRechargeDO);
    }
    
    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public AirRechargeDO getAirRechargeEntity(AirRechargeDO airRechargeDO) {
        return super.get("airRecharge_select", airRechargeDO);
    }

    /**
     * 描述： select count air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeCount(AirRechargeDO airRechargeDO) {
        return (Integer) super.getTotalCount("airRecharge_count", airRechargeDO);
    }

    /**
     * 描述： insert into air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRecharge(AirRechargeDO airRechargeDO) {
        return super.update("airRecharge_insert", airRechargeDO);
    }

    /**
     * 描述： update air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRecharge(AirRechargeDO airRechargeDO) {
        return super.update("airRecharge_update", airRechargeDO);
    }

    /**
     * 描述： delete from air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRecharge(AirRechargeDO airRechargeDO) {
        return super.update("airRecharge_delete", airRechargeDO);
    }
}

package com.aoyetech.fee.dal.dao.rechage.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechage.RechargeDAO;
import com.aoyetech.fee.domain.recharge.RechargeDO;


@Repository
public class RechargeDAOImpl extends MybatisTemplate implements RechargeDAO {

    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeDO> getAirRechargeList(RechargeDO airRechargeDO) {
        return super.queryForList("airRecharge_select", airRechargeDO);
    }
    
    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeDO getAirRechargeEntity(RechargeDO airRechargeDO) {
        return super.get("airRecharge_select", airRechargeDO);
    }

    /**
     * 描述： select count air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeCount(RechargeDO airRechargeDO) {
        return (Integer) super.getTotalCount("airRecharge_count", airRechargeDO);
    }

    /**
     * 描述： insert into air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRecharge(RechargeDO airRechargeDO) {
        return super.update("airRecharge_insert", airRechargeDO);
    }

    /**
     * 描述： update air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRecharge(RechargeDO airRechargeDO) {
        return super.update("airRecharge_update", airRechargeDO);
    }

    /**
     * 描述： delete from air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRecharge(RechargeDO airRechargeDO) {
        return super.update("airRecharge_delete", airRechargeDO);
    }
}

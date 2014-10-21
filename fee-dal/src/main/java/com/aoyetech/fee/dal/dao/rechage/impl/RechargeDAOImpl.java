package com.aoyetech.fee.dal.dao.rechage.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechage.RechargeDAO;
import com.aoyetech.fee.domain.recharge.RechargeDO;


@Repository
public class RechargeDAOImpl extends MybatisTemplate implements RechargeDAO {

    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeDO> getRechargeList(RechargeDO RechargeDO) {
        return super.queryForList("Recharge_select", RechargeDO);
    }
    
    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeDO getRechargeEntity(RechargeDO RechargeDO) {
        return super.get("Recharge_select", RechargeDO);
    }

    /**
     * 描述： select count _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getRechargeCount(RechargeDO RechargeDO) {
        return (Integer) super.getTotalCount("Recharge_count", RechargeDO);
    }

    /**
     * 描述： insert into _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertRecharge(RechargeDO RechargeDO) {
        return super.update("Recharge_insert", RechargeDO);
    }

    /**
     * 描述： update _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateRecharge(RechargeDO RechargeDO) {
        return super.update("Recharge_update", RechargeDO);
    }

    /**
     * 描述： delete from _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteRecharge(RechargeDO RechargeDO) {
        return super.update("Recharge_delete", RechargeDO);
    }
}

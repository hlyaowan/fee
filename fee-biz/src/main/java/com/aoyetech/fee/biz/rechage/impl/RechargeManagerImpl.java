package com.aoyetech.fee.biz.rechage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aoyetech.fee.biz.rechage.RechargeManager;
import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechage.RechargeDAO;
import com.aoyetech.fee.domain.recharge.RechargeDO;


@Component
public class RechargeManagerImpl  implements RechargeManager {

    @Autowired
    private RechargeDAO RechargeDAO;
    
    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeDO> getRechargeList(Integer start,Integer count,Integer appId) {
        RechargeDO rechargeDO =new RechargeDO();
        rechargeDO.setStart(start);
        rechargeDO.setCount(count);
        rechargeDO.setAppId(appId);
        return RechargeDAO.getRechargeList(rechargeDO);
    }
    
    /**
     * 描述： select _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeDO getRechargeEntity(RechargeDO RechargeDO) {
        return RechargeDAO.getRechargeEntity(RechargeDO);
    }

    /**
     * 描述： select count _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getRechargeCount(RechargeDO RechargeDO) {
        return RechargeDAO.getRechargeCount(RechargeDO);
    }

    /**
     * 描述： insert into _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertRecharge(RechargeDO RechargeDO) {
        return RechargeDAO.insertRecharge(RechargeDO);
    }

    /**
     * 描述： update _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateRecharge(RechargeDO RechargeDO) {
        return RechargeDAO.updateRecharge(RechargeDO);
    }

    /**
     * 描述： delete from _recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteRecharge(RechargeDO RechargeDO) {
        return RechargeDAO.deleteRecharge(RechargeDO);
    }
}

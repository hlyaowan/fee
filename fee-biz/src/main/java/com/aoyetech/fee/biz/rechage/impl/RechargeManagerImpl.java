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
    private RechargeDAO airRechargeDAO;
    
    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeDO> getAirRechargeList(int start,int count) {
        RechargeDO airRechargeDO =new RechargeDO();
        airRechargeDO.setStart(start);
        airRechargeDO.setCount(count);
        return airRechargeDAO.getAirRechargeList(airRechargeDO);
    }
    
    /**
     * 描述： select air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeDO getAirRechargeEntity(RechargeDO airRechargeDO) {
        return airRechargeDAO.getAirRechargeEntity(airRechargeDO);
    }

    /**
     * 描述： select count air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeCount(RechargeDO airRechargeDO) {
        return airRechargeDAO.getAirRechargeCount(airRechargeDO);
    }

    /**
     * 描述： insert into air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRecharge(RechargeDO airRechargeDO) {
        return airRechargeDAO.insertAirRecharge(airRechargeDO);
    }

    /**
     * 描述： update air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRecharge(RechargeDO airRechargeDO) {
        return airRechargeDAO.updateAirRecharge(airRechargeDO);
    }

    /**
     * 描述： delete from air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRecharge(RechargeDO airRechargeDO) {
        return airRechargeDAO.deleteAirRecharge(airRechargeDO);
    }
}

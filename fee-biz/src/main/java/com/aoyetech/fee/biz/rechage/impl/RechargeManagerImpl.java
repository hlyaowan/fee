package com.aoyetech.fee.biz.rechage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aoyetech.fee.biz.rechage.RechargeManager;
import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechage.RechargeDAO;
import com.aoyetech.fee.domain.recharge.AirRechargeDO;


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
    public List<AirRechargeDO> getAirRechargeList(int start,int count) {
        AirRechargeDO airRechargeDO =new AirRechargeDO();
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
    public AirRechargeDO getAirRechargeEntity(AirRechargeDO airRechargeDO) {
        return airRechargeDAO.getAirRechargeEntity(airRechargeDO);
    }

    /**
     * 描述： select count air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeCount(AirRechargeDO airRechargeDO) {
        return airRechargeDAO.getAirRechargeCount(airRechargeDO);
    }

    /**
     * 描述： insert into air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRecharge(AirRechargeDO airRechargeDO) {
        return airRechargeDAO.insertAirRecharge(airRechargeDO);
    }

    /**
     * 描述： update air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRecharge(AirRechargeDO airRechargeDO) {
        return airRechargeDAO.updateAirRecharge(airRechargeDO);
    }

    /**
     * 描述： delete from air_recharge
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRecharge(AirRechargeDO airRechargeDO) {
        return airRechargeDAO.deleteAirRecharge(airRechargeDO);
    }
}

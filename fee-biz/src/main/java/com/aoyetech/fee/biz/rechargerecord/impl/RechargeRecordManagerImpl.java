package com.aoyetech.fee.biz.rechargerecord.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aoyetech.fee.biz.rechargerecord.RechargeRecordManager;
import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechargerecord.RechargeRecordDAO;
import com.aoyetech.fee.domain.rechargerecord.RechargeRecordDO;


@Component
public class RechargeRecordManagerImpl implements RechargeRecordManager {

    @Autowired
    private RechargeRecordDAO airRechargeRecordDAO;
    
    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeRecordDO> getAirRechargeRecordList(RechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.getAirRechargeRecordList(airRechargeRecordDO);
    }
    
    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeRecordDO getAirRechargeRecordEntity(RechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.getAirRechargeRecordEntity(airRechargeRecordDO);
    }

    /**
     * 描述： select count air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeRecordCount(RechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.getAirRechargeRecordCount(airRechargeRecordDO);
    }

    /**
     * 描述： insert into air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRechargeRecord(RechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.insertAirRechargeRecord(airRechargeRecordDO);
    }

    /**
     * 描述： update air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRechargeRecord(RechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.updateAirRechargeRecord(airRechargeRecordDO);
    }

    /**
     * 描述： delete from air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRechargeRecord(RechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.deleteAirRechargeRecord(airRechargeRecordDO);
    }
}

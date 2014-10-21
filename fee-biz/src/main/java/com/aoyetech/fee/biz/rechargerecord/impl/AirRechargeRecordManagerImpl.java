package com.aoyetech.fee.biz.rechargerecord.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aoyetech.fee.biz.rechargerecord.AirRechargeRecordManager;
import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechargerecord.AirRechargeRecordDAO;
import com.aoyetech.fee.domain.rechargerecord.AirRechargeRecordDO;


@Component
public class AirRechargeRecordManagerImpl implements AirRechargeRecordManager {

    @Autowired
    private AirRechargeRecordDAO airRechargeRecordDAO;
    
    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<AirRechargeRecordDO> getAirRechargeRecordList(AirRechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.getAirRechargeRecordList(airRechargeRecordDO);
    }
    
    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public AirRechargeRecordDO getAirRechargeRecordEntity(AirRechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.getAirRechargeRecordEntity(airRechargeRecordDO);
    }

    /**
     * 描述： select count air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeRecordCount(AirRechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.getAirRechargeRecordCount(airRechargeRecordDO);
    }

    /**
     * 描述： insert into air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRechargeRecord(AirRechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.insertAirRechargeRecord(airRechargeRecordDO);
    }

    /**
     * 描述： update air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRechargeRecord(AirRechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.updateAirRechargeRecord(airRechargeRecordDO);
    }

    /**
     * 描述： delete from air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRechargeRecord(AirRechargeRecordDO airRechargeRecordDO) {
        return airRechargeRecordDAO.deleteAirRechargeRecord(airRechargeRecordDO);
    }
}

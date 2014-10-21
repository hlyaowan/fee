package com.aoyetech.fee.dal.dao.rechargerecord.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechargerecord.RechargeRecordDAO;
import com.aoyetech.fee.domain.rechargerecord.RechargeRecordDO;


@Repository
public class RechargeRecordDAOImpl extends MybatisTemplate implements RechargeRecordDAO {

    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeRecordDO> getAirRechargeRecordList(RechargeRecordDO airRechargeRecordDO) {
        return super.queryForList("airRechargeRecord_select", airRechargeRecordDO);
    }
    
    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeRecordDO getAirRechargeRecordEntity(RechargeRecordDO airRechargeRecordDO) {
        return super.get("airRechargeRecord_select", airRechargeRecordDO);
    }

    /**
     * 描述： select count air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirRechargeRecordCount(RechargeRecordDO airRechargeRecordDO) {
        return (Integer) super.getTotalCount("airRechargeRecord_count", airRechargeRecordDO);
    }

    /**
     * 描述： insert into air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirRechargeRecord(RechargeRecordDO airRechargeRecordDO) {
        return super.update("airRechargeRecord_insert", airRechargeRecordDO);
    }

    /**
     * 描述： update air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirRechargeRecord(RechargeRecordDO airRechargeRecordDO) {
        return super.update("airRechargeRecord_update", airRechargeRecordDO);
    }

    /**
     * 描述： delete from air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirRechargeRecord(RechargeRecordDO airRechargeRecordDO) {
        return super.update("airRechargeRecord_delete", airRechargeRecordDO);
    }
}

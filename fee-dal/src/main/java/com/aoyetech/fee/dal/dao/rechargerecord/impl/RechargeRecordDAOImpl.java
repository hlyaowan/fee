package com.aoyetech.fee.dal.dao.rechargerecord.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.rechargerecord.RechargeRecordDAO;
import com.aoyetech.fee.domain.rechargerecord.RechargeRecordDO;


@Repository
public class RechargeRecordDAOImpl extends MybatisTemplate implements RechargeRecordDAO {

    /**
     * 描述： select _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeRecordDO> getRechargeRecordList(RechargeRecordDO RechargeRecordDO) {
        return super.queryForList("RechargeRecord_select", RechargeRecordDO);
    }
    
    /**
     * 描述： select _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeRecordDO getRechargeRecordEntity(RechargeRecordDO RechargeRecordDO) {
        return super.get("RechargeRecord_select", RechargeRecordDO);
    }

    /**
     * 描述： select count _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getRechargeRecordCount(RechargeRecordDO RechargeRecordDO) {
        return (Integer) super.getTotalCount("RechargeRecord_count", RechargeRecordDO);
    }

    /**
     * 描述： insert into _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertRechargeRecord(RechargeRecordDO RechargeRecordDO) {
        return super.update("RechargeRecord_insert", RechargeRecordDO);
    }

    /**
     * 描述： update _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateRechargeRecord(RechargeRecordDO RechargeRecordDO) {
        return super.update("RechargeRecord_update", RechargeRecordDO);
    }

    /**
     * 描述： delete from _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteRechargeRecord(RechargeRecordDO RechargeRecordDO) {
        return super.update("RechargeRecord_delete", RechargeRecordDO);
    }
}

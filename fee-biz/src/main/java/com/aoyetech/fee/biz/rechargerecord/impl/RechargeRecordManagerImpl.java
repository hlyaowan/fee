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
    private RechargeRecordDAO RechargeRecordDAO;
    
    /**
     * 描述： select _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<RechargeRecordDO> getRechargeRecordList(RechargeRecordDO RechargeRecordDO) {
        return RechargeRecordDAO.getRechargeRecordList(RechargeRecordDO);
    }
    
    /**
     * 描述： select _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public RechargeRecordDO getRechargeRecordEntity(RechargeRecordDO RechargeRecordDO) {
        return RechargeRecordDAO.getRechargeRecordEntity(RechargeRecordDO);
    }

    /**
     * 描述： select count _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getRechargeRecordCount(RechargeRecordDO RechargeRecordDO) {
        return RechargeRecordDAO.getRechargeRecordCount(RechargeRecordDO);
    }

    /**
     * 描述： insert into _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertRechargeRecord(RechargeRecordDO RechargeRecordDO) {
        return RechargeRecordDAO.insertRechargeRecord(RechargeRecordDO);
    }

    /**
     * 描述： update _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateRechargeRecord(RechargeRecordDO RechargeRecordDO) {
        return RechargeRecordDAO.updateRechargeRecord(RechargeRecordDO);
    }

    /**
     * 描述： delete from _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteRechargeRecord(RechargeRecordDO RechargeRecordDO) {
        return RechargeRecordDAO.deleteRechargeRecord(RechargeRecordDO);
    }
}

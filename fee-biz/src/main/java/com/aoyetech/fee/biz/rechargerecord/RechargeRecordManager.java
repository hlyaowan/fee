package com.aoyetech.fee.biz.rechargerecord;

import java.util.List;

import com.aoyetech.fee.domain.rechargerecord.RechargeRecordDO;

public interface RechargeRecordManager {

    /**
     * 描述： select _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<RechargeRecordDO> getRechargeRecordList(RechargeRecordDO RechargeRecordDO);
    /**
     * 描述： select _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public RechargeRecordDO getRechargeRecordEntity(RechargeRecordDO RechargeRecordDO);

    /**
     * 描述： select count _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getRechargeRecordCount(RechargeRecordDO RechargeRecordDO);

    /**
     * 描述： insert into _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertRechargeRecord(RechargeRecordDO RechargeRecordDO);

    /**
     * 描述： update _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateRechargeRecord(RechargeRecordDO RechargeRecordDO);

    /**
     * 描述： delete from _recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteRechargeRecord(RechargeRecordDO RechargeRecordDO);
}

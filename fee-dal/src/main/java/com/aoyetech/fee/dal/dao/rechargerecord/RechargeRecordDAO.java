package com.aoyetech.fee.dal.dao.rechargerecord;

import java.util.List;

import com.aoyetech.fee.domain.rechargerecord.RechargeRecordDO;

public interface RechargeRecordDAO {

    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<RechargeRecordDO> getAirRechargeRecordList(RechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public RechargeRecordDO getAirRechargeRecordEntity(RechargeRecordDO airRechargeRecordDO);
    /**
     * 描述： select count air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirRechargeRecordCount(RechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： insert into air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirRechargeRecord(RechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： update air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirRechargeRecord(RechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： delete from air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirRechargeRecord(RechargeRecordDO airRechargeRecordDO);
}

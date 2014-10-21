package com.aoyetech.fee.dal.dao.rechargerecord;

import java.util.List;

import com.aoyetech.fee.domain.rechargerecord.AirRechargeRecordDO;

public interface RechargeRecordDAO {

    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AirRechargeRecordDO> getAirRechargeRecordList(AirRechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： select air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public AirRechargeRecordDO getAirRechargeRecordEntity(AirRechargeRecordDO airRechargeRecordDO);
    /**
     * 描述： select count air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirRechargeRecordCount(AirRechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： insert into air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirRechargeRecord(AirRechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： update air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirRechargeRecord(AirRechargeRecordDO airRechargeRecordDO);

    /**
     * 描述： delete from air_recharge_record
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirRechargeRecord(AirRechargeRecordDO airRechargeRecordDO);
}

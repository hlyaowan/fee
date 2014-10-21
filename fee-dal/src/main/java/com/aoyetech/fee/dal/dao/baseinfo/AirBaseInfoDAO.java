package com.aoyetech.fee.dal.dao.baseinfo;

import java.util.List;

import com.aoyetech.fee.domain.baseinfo.AirBaseInfoDO;

public interface AirBaseInfoDAO {
    /**
     * 描述： select air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AirBaseInfoDO> getAirBaseInfoList(AirBaseInfoDO airBaseInfoDO);
    /**
     * 描述： select air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public AirBaseInfoDO getAirBaseInfoEntity(AirBaseInfoDO airBaseInfoDO);

    /**
     * 描述： select count air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirBaseInfoCount(AirBaseInfoDO airBaseInfoDO);

    /**
     * 描述： insert into air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirBaseInfo(AirBaseInfoDO airBaseInfoDO);

    /**
     * 描述： update air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirBaseInfo(AirBaseInfoDO airBaseInfoDO);

    /**
     * 描述： delete from air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirBaseInfo(AirBaseInfoDO airBaseInfoDO);
}

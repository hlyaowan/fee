package com.aoyetech.fee.biz.baseinfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoyetech.fee.biz.baseinfo.AirBaseInfoManager;
import com.aoyetech.fee.dal.dao.baseinfo.AirBaseInfoDAO;
import com.aoyetech.fee.domain.baseinfo.AirBaseInfoDO;


@Component
public class AirBaseInfoManagerImpl implements AirBaseInfoManager {
    
    @Autowired
    private AirBaseInfoDAO airBaseInfoDAO;

    /**
     * 描述： select air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<AirBaseInfoDO> getAirBaseInfoList(AirBaseInfoDO airBaseInfoDO) {
        return airBaseInfoDAO.getAirBaseInfoList(airBaseInfoDO);
    }
    
    /**
     * 描述： select air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public AirBaseInfoDO getAirBaseInfoEntity(AirBaseInfoDO airBaseInfoDO) {
        return airBaseInfoDAO.getAirBaseInfoEntity(airBaseInfoDO);
    }

    /**
     * 描述： select count air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirBaseInfoCount(AirBaseInfoDO airBaseInfoDO) {
        return airBaseInfoDAO.getAirBaseInfoCount(airBaseInfoDO);
    }

    /**
     * 描述： insert into air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirBaseInfo(AirBaseInfoDO airBaseInfoDO) {
        return airBaseInfoDAO.insertAirBaseInfo(airBaseInfoDO);
    }

    /**
     * 描述： update air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirBaseInfo(AirBaseInfoDO airBaseInfoDO) {
        return airBaseInfoDAO.updateAirBaseInfo(airBaseInfoDO);
    }

    /**
     * 描述： delete from air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirBaseInfo(AirBaseInfoDO airBaseInfoDO) {
        return airBaseInfoDAO.deleteAirBaseInfo(airBaseInfoDO);
    }
}

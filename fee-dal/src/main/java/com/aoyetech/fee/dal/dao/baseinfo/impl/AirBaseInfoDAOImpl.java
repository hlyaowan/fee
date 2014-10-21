package com.aoyetech.fee.dal.dao.baseinfo.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.baseinfo.AirBaseInfoDAO;
import com.aoyetech.fee.domain.baseinfo.AirBaseInfoDO;


@Repository
public class AirBaseInfoDAOImpl extends MybatisTemplate implements AirBaseInfoDAO {

    /**
     * 描述： select air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<AirBaseInfoDO> getAirBaseInfoList(AirBaseInfoDO airBaseInfoDO) {
        return super.queryForList("airBaseInfo_select", airBaseInfoDO);
    }
    
    /**
     * 描述： select air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public AirBaseInfoDO getAirBaseInfoEntity(AirBaseInfoDO airBaseInfoDO) {
        return super.get("airBaseInfo_select", airBaseInfoDO);
    }

    /**
     * 描述： select count air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirBaseInfoCount(AirBaseInfoDO airBaseInfoDO) {
        return (Integer) super.getTotalCount("airBaseInfo_count", airBaseInfoDO);
    }

    /**
     * 描述： insert into air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirBaseInfo(AirBaseInfoDO airBaseInfoDO) {
        return super.update("airBaseInfo_insert", airBaseInfoDO);
    }

    /**
     * 描述： update air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirBaseInfo(AirBaseInfoDO airBaseInfoDO) {
        return super.update("airBaseInfo_update", airBaseInfoDO);
    }

    /**
     * 描述： delete from air_base_info
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirBaseInfo(AirBaseInfoDO airBaseInfoDO) {
        return super.update("airBaseInfo_delete", airBaseInfoDO);
    }
}

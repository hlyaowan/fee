package com.aoyetech.fee.biz.useext.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoyetech.fee.biz.useext.UserExtManager;
import com.aoyetech.fee.dal.dao.useext.UserExtDAO;
import com.aoyetech.fee.domain.ext.UserExtDO;


@Component
public class UserExtManagerImpl implements UserExtManager {

    @Autowired
    private UserExtDAO userExtDAO;
    /**
     * 描述： select air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<UserExtDO> getAirUserExtList(UserExtDO airUserExtDO) {
        return userExtDAO.getAirUserExtList(airUserExtDO);
    }
    
    
    /**
     * 描述： select air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public UserExtDO getAirUserExtInfo(UserExtDO airUserExtDO) {
        return userExtDAO.getAirUserExtInfo(airUserExtDO);
    }

    /**
     * 描述： select count air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirUserExtCount(UserExtDO airUserExtDO) {
        return userExtDAO.getAirUserExtCount(airUserExtDO);
    }

    /**
     * 描述： insert into air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirUserExt(UserExtDO airUserExtDO) {
        return userExtDAO.insertAirUserExt(airUserExtDO);
    }

    /**
     * 描述： update air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirUserExt(UserExtDO airUserExtDO) {
        return userExtDAO.updateAirUserExt(airUserExtDO);
    }

    /**
     * 描述： delete from air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirUserExt(UserExtDO airUserExtDO) {
        return userExtDAO.deleteAirUserExt(airUserExtDO);
    }
}

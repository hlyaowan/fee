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
     * 描述： select _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<UserExtDO> getUserExtList(UserExtDO UserExtDO) {
        return userExtDAO.getUserExtList(UserExtDO);
    }
    
    
    /**
     * 描述： select _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public UserExtDO getUserExtInfo(UserExtDO UserExtDO) {
        return userExtDAO.getUserExtInfo(UserExtDO);
    }

    /**
     * 描述： select count _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getUserExtCount(UserExtDO UserExtDO) {
        return userExtDAO.getUserExtCount(UserExtDO);
    }

    /**
     * 描述： insert into _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertUserExt(UserExtDO UserExtDO) {
        return userExtDAO.insertUserExt(UserExtDO);
    }

    /**
     * 描述： update _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateUserExt(UserExtDO UserExtDO) {
        return userExtDAO.updateUserExt(UserExtDO);
    }

    /**
     * 描述： delete from _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteUserExt(UserExtDO UserExtDO) {
        return userExtDAO.deleteUserExt(UserExtDO);
    }
}

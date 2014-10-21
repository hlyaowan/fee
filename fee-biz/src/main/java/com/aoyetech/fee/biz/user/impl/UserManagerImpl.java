package com.aoyetech.fee.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoyetech.fee.biz.user.UserManager;
import com.aoyetech.fee.dal.dao.user.UserDAO;
import com.aoyetech.fee.domain.user.UserInfoDO;

/***
 * 
 * @author huanglei
 * @version $Id: UserManagerImpl.java,v 0.1 2014年9月17日 上午12:25:48 hlyaowan Exp $
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserInfoDO getUserInfo(String uid) {
        return userDAO.getUserInfo(uid);
    }
    
    /**
     * 描述： insert into air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertAirUser(UserInfoDO airUserDO){
        return userDAO.insertAirUser(airUserDO);
    }
    
    /**
     * 描述： select air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<UserInfoDO> getAirUserList(UserInfoDO airUserDO){
        return userDAO.getAirUserList(airUserDO);
    }

    /**
     * 描述： select count air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getAirUserCount(UserInfoDO airUserDO){
        return userDAO.getAirUserCount(airUserDO);
    }


    /**
     * 描述： update air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateAirUser(UserInfoDO airUserDO){
        return userDAO.updateAirUser(airUserDO);
    }

    /**
     * 描述： delete from air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteAirUser(UserInfoDO airUserDO){
        return userDAO.deleteAirUser(airUserDO);
    }
}

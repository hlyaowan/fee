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
     * 描述： insert into _user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer insertUser(UserInfoDO UserDO){
        return userDAO.insertUser(UserDO);
    }
    
    /**
     * 描述： select _user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public List<UserInfoDO> getUserList(UserInfoDO UserDO){
        return userDAO.getUserList(UserDO);
    }

    /**
     * 描述： select count _user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer getUserCount(UserInfoDO UserDO){
        return userDAO.getUserCount(UserDO);
    }


    /**
     * 描述： update _user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer updateUser(UserInfoDO UserDO){
        return userDAO.updateUser(UserDO);
    }

    /**
     * 描述： delete from _user
     * @author 黄磊
     * Date 2014-09-17
     */
    @Override
    public Integer deleteUser(UserInfoDO UserDO){
        return userDAO.deleteUser(UserDO);
    }
}

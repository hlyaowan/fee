package com.aoyetech.fee.dal.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.user.UserDAO;
import com.aoyetech.fee.domain.user.UserInfoDO;

@Repository
public class UserDAOImpl extends MybatisTemplate implements UserDAO {
    private static final String NAMESPACE = UserDAO.class.getName().concat(".");

    /***
     * 获取用户信息
     * @return
     */
    @Override
    public UserInfoDO getUserInfo(String uid) {
        UserInfoDO userInfo = new UserInfoDO();
        userInfo.setName(uid);
        return super.get(NAMESPACE.concat("getUserInfoDO"), userInfo);
    }

    /**
     * 描述： select _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserInfoDO> getUserList(UserInfoDO UserDO) {
        return super.queryForList("User_select", UserDO);
    }

    /**
     * 描述： select count _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getUserCount(UserInfoDO UserDO) {
        return (Integer) super.getTotalCount("User_count", UserDO);
    }

    /**
     * 描述： insert into _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertUser(UserInfoDO UserDO) {
        return super.update("User_insert", UserDO);
    }

    /**
     * 描述： update _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateUser(UserInfoDO UserDO) {
        return super.update("User_update", UserDO);
    }

    /**
     * 描述： delete from _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteUser(UserInfoDO UserDO) {
        return super.update("User_delete", UserDO);
    }
}

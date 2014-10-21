package com.aoyetech.fee.dal.dao.user;

import java.util.List;

import com.aoyetech.fee.domain.user.UserInfoDO;

public interface UserDAO {
    /***
     * 获取用户信息
     * @return
     */
    public UserInfoDO getUserInfo(String uid);

    /**
     * 描述： select _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserInfoDO> getUserList(UserInfoDO UserDO);

    /**
     * 描述： select count _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getUserCount(UserInfoDO UserDO);

    /**
     * 描述： insert into _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertUser(UserInfoDO UserDO);

    /**
     * 描述： update _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateUser(UserInfoDO UserDO);

    /**
     * 描述： delete from _user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteUser(UserInfoDO UserDO);
}

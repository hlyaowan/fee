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
     * 描述： select air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserInfoDO> getAirUserList(UserInfoDO airUserDO) {
        return super.queryForList("airUser_select", airUserDO);
    }

    /**
     * 描述： select count air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirUserCount(UserInfoDO airUserDO) {
        return (Integer) super.getTotalCount("airUser_count", airUserDO);
    }

    /**
     * 描述： insert into air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirUser(UserInfoDO airUserDO) {
        return super.update("airUser_insert", airUserDO);
    }

    /**
     * 描述： update air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirUser(UserInfoDO airUserDO) {
        return super.update("airUser_update", airUserDO);
    }

    /**
     * 描述： delete from air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirUser(UserInfoDO airUserDO) {
        return super.update("airUser_delete", airUserDO);
    }
}

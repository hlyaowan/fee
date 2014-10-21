package com.aoyetech.fee.dal.dao.useext.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.useext.UserExtDAO;
import com.aoyetech.fee.domain.ext.UserExtDO;


@Repository
public class UserExtDAOImpl extends MybatisTemplate implements UserExtDAO {

    /**
     * 描述： select _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserExtDO> getUserExtList(UserExtDO UserExtDO) {
        return super.queryForList("UserExt_select", UserExtDO);
    }
    
    /**
     * 描述： select _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public UserExtDO getUserExtInfo(UserExtDO UserExtDO) {
        return (UserExtDO)super.get("UserExt_select_entity", UserExtDO);
    }

    /**
     * 描述： select count _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getUserExtCount(UserExtDO UserExtDO) {
        return (Integer) super.getTotalCount("UserExt_count", UserExtDO);
    }

    /**
     * 描述： insert into _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertUserExt(UserExtDO UserExtDO) {
        return super.save("UserExt_insert", UserExtDO);
    }

    /**
     * 描述： update _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateUserExt(UserExtDO UserExtDO) {
        return super.update("UserExt_update", UserExtDO);
    }

    /**
     * 描述： delete from _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteUserExt(UserExtDO UserExtDO) {
        return super.update("UserExt_delete", UserExtDO);
    }
}

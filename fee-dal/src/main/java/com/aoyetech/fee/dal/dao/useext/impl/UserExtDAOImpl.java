package com.aoyetech.fee.dal.dao.useext.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.useext.UserExtDAO;
import com.aoyetech.fee.domain.ext.UserExtDO;


@Repository
public class UserExtDAOImpl extends MybatisTemplate implements UserExtDAO {

    /**
     * 描述： select air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserExtDO> getAirUserExtList(UserExtDO airUserExtDO) {
        return super.queryForList("airUserExt_select", airUserExtDO);
    }
    
    /**
     * 描述： select air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public UserExtDO getAirUserExtInfo(UserExtDO airUserExtDO) {
        return (UserExtDO)super.get("airUserExt_select_entity", airUserExtDO);
    }

    /**
     * 描述： select count air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirUserExtCount(UserExtDO airUserExtDO) {
        return (Integer) super.getTotalCount("airUserExt_count", airUserExtDO);
    }

    /**
     * 描述： insert into air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirUserExt(UserExtDO airUserExtDO) {
        return super.save("airUserExt_insert", airUserExtDO);
    }

    /**
     * 描述： update air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirUserExt(UserExtDO airUserExtDO) {
        return super.update("airUserExt_update", airUserExtDO);
    }

    /**
     * 描述： delete from air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirUserExt(UserExtDO airUserExtDO) {
        return super.update("airUserExt_delete", airUserExtDO);
    }
}

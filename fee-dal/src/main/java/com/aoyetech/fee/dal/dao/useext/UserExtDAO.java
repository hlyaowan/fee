package com.aoyetech.fee.dal.dao.useext;

import java.util.List;

import com.aoyetech.fee.domain.ext.UserExtDO;

public interface UserExtDAO {
    /**
     * 描述： select _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserExtDO> getUserExtList(UserExtDO UserExtDO);
    /**
     * 描述： select _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public UserExtDO getUserExtInfo(UserExtDO UserExtDO);
    /**
     * 描述： select count _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getUserExtCount(UserExtDO UserExtDO);

    /**
     * 描述： insert into _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertUserExt(UserExtDO UserExtDO);

    /**
     * 描述： update _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateUserExt(UserExtDO UserExtDO);

    /**
     * 描述： delete from _user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteUserExt(UserExtDO UserExtDO);
}

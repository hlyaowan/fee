package com.aoyetech.fee.biz.user;

import java.util.List;

import com.aoyetech.fee.domain.user.UserInfoDO;



public interface UserManager {

    public UserInfoDO getUserInfo(String uid);
    /**
     * 描述： select air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<UserInfoDO> getAirUserList(UserInfoDO airUserDO);

    /**
     * 描述： select count air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirUserCount(UserInfoDO airUserDO);

    /**
     * 描述： insert into air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirUser(UserInfoDO airUserDO);

    /**
     * 描述： update air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirUser(UserInfoDO airUserDO);

    /**
     * 描述： delete from air_user
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirUser(UserInfoDO airUserDO);
    
    
}

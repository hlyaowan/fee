package com.aoyetech.fee.biz.useext;

import java.util.List;

import com.aoyetech.fee.domain.ext.AirUserExtDO;

public interface UserExtManager {
    /**
     * 描述： select air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AirUserExtDO> getAirUserExtList(AirUserExtDO airUserExtDO);
    /**
     * 描述： select air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public AirUserExtDO getAirUserExtInfo(AirUserExtDO airUserExtDO);

    /**
     * 描述： select count air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAirUserExtCount(AirUserExtDO airUserExtDO);

    /**
     * 描述： insert into air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAirUserExt(AirUserExtDO airUserExtDO);

    /**
     * 描述： update air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAirUserExt(AirUserExtDO airUserExtDO);

    /**
     * 描述： delete from air_user_ext
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer deleteAirUserExt(AirUserExtDO airUserExtDO);
}

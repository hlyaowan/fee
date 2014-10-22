package com.aoyetech.fee.dal.dao.appinfo;

import java.util.List;

import com.aoyetech.fee.domain.app.AppInfo;

public interface AppInfoDAO {
    /**
     * 描述： select app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AppInfo> getAppInfoList(AppInfo appInfo);

    /**
     * 描述： select app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public AppInfo getAppInfoInfo(Integer appId);

    /**
     * 描述： select count app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAppInfoCount(AppInfo appInfo);

    /**
     * 描述： insert into app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAppInfo(AppInfo appInfo);

    /**
     * 描述： update app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAppInfo(AppInfo appInfo);

    /**
     * 描述： delete from app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public void deleteAppInfo(Integer appId);
}

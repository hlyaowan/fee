package com.aoyetech.fee.biz.appinfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aoyetech.fee.biz.appinfo.AppInfoManager;
import com.aoyetech.fee.dal.dao.appinfo.AppInfoDAO;
import com.aoyetech.fee.domain.app.AppInfo;

@Component
public class AppInfoManagerImpl implements AppInfoManager{
    
    @Autowired
    private AppInfoDAO appInfoDAO;
    /**
     * 描述： select app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AppInfo> getAppInfoList(AppInfo appInfo){
        return appInfoDAO.getAppInfoList(appInfo);
    }

    /**
     * 描述： select app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public AppInfo getAppInfoInfo(Integer appId){
        return appInfoDAO.getAppInfoInfo(appId);
    }

    /**
     * 描述： select count app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAppInfoCount(AppInfo appInfo){
        return appInfoDAO.getAppInfoCount(appInfo);
    }

    /**
     * 描述： insert into app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAppInfo(AppInfo appInfo){
        return appInfoDAO.insertAppInfo(appInfo);
    }

    /**
     * 描述： update app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAppInfo(AppInfo appInfo){
        return appInfoDAO.updateAppInfo(appInfo);
    }

    /**
     * 描述： delete from app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public void deleteAppInfo(Integer appId){
        appInfoDAO.deleteAppInfo(appId);
    }
}

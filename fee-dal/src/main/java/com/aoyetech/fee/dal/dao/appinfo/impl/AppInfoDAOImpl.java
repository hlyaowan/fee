package com.aoyetech.fee.dal.dao.appinfo.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.aoyetech.fee.dal.core.mybatis.MybatisTemplate;
import com.aoyetech.fee.dal.dao.appinfo.AppInfoDAO;
import com.aoyetech.fee.domain.app.AppInfo;


@Repository
public class AppInfoDAOImpl extends MybatisTemplate implements AppInfoDAO{

    
    /**
     * 描述： select app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public List<AppInfo> getAppInfoList(AppInfo appInfo){
        return super.queryForList("", appInfo);
    }

    /**
     * 描述： select app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public AppInfo getAppInfoInfo(Integer appId){
        AppInfo appinfo =new AppInfo();
        appinfo.setAppId(appId);
        return super.get("", appinfo);
        
    }

    /**
     * 描述： select count app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer getAppInfoCount(AppInfo appInfo){
        return super.queryForListCount("", appInfo);
    }

    /**
     * 描述： insert into app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer insertAppInfo(AppInfo appInfo){
        return super.save("", appInfo);
    }

    /**
     * 描述： update app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public Integer updateAppInfo(AppInfo appInfo){
        return super.update("", appInfo);
    }

    /**
     * 描述： delete from app_info
     * @author 黄磊
     * Date 2014-09-17
     */
    public void deleteAppInfo(Integer appId){
        AppInfo appInfo =new AppInfo();
        appInfo.setAppId(appId);
        super.delete("", appInfo);
    }
}
